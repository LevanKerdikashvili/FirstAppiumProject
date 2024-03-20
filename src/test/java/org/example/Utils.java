package org.example;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class Utils {


    protected AndroidDriver driver;


    public Utils(AndroidDriver driver) {
        this.driver = driver;
    }


    public void clickToSwitchApp() {
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
    }

    public void clickToHomeBtn() {
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }


}
