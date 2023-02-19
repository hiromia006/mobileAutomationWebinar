package com.emi.calculator.test.util;

public class General {
    public static final int LOAD_WAIT_TIME = 30;

    public static void waitForDomStable(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
