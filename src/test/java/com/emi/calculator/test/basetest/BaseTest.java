package com.emi.calculator.test.basetest;

import com.emi.calculator.test.util.General;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public abstract class BaseTest {
    public static AndroidDriver driver;

    @AfterClass
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid", "192.168.56.101:5555");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("appPackage", "com.continuum.emi.calculator");
        capabilities.setCapability("appActivity", "com.finance.emicalci.activity.Splash_screnn");
        capabilities.setCapability("platformName", "Android");

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(General.LOAD_WAIT_TIME));
        driver.startRecordingScreen();

    }

    @AfterClass
    public void tearDown() {
        General.waitForDomStable();
        stopRecording();
        driver.quit();
    }

    protected void stopRecording() {
        String base64String = driver.stopRecordingScreen();
        byte[] data = Base64.decodeBase64(base64String);

        //prepare video save directory path
        String projectHomeDirectory = System.getProperty("user.dir");
        System.out.println("projectHomeDirectory :" + projectHomeDirectory);
        String destinationPath = projectHomeDirectory + "/build/videos";

        File theDir = new File(destinationPath);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }

        String filePath = destinationPath + "/" + driver.getDeviceTime().replace(":", "_").replace("+", " ") + ".mp4";
        System.out.println("filePath : " + filePath);
        Path path = Paths.get(filePath);
        try {
            Files.write(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
