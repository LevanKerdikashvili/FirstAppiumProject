package org.example.pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Step;
import org.example.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class LoginPage {

    protected AndroidDriver driver;
    private WebDriverWait wait;

    private Utils utils;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait
        PageFactory.initElements(driver, this);
        utils = new Utils(driver);
    }


    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    private WebElement username;


    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    private WebElement password;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    private WebElement loginBtn;


    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    private WebElement loginErrorMessage;


    /**
     * The function `fillUsernameWithPassword` fills the username and password fields and with provided values and
     * *optionally clicks a login button.
     *
     * @param user       The `user` parameter is a String that represents the username.
     * @param pass       The `pass` parameter is a String that represents the password.
     * @param clickToBtn is a boolean flag that determines whether to click a login button after filling in the
     *                   username and password fields.
     **/


    @Step("ეს მეთოდი ავსებს ინფორმაციას მომხამრებელს და პაროლს")
    public void fillUsernameWithPassword(String user, String pass, boolean clickToBtn) {

        sendKey(user, username); // text  -  webElement
        sendKey(pass, password);// text  -  webElement

        if (clickToBtn) {
            // clickToLogin();
            clickToBtn(loginBtn);
        }

    }

    @Step("ეს არის უბრალო მეთოდი - სტეპი")
    public void simpleMethod() {
        //
    }


    public void sendKey(String txt, WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(txt);
    }


    public void clickToLogin() {
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        loginBtn.click();
    }


    public void clickToBtn(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


    public void checkErrorText(String expectedMsg) {
        wait.until(ExpectedConditions.visibilityOf(loginErrorMessage));
        Assert.assertEquals(loginErrorMessage.getText(), expectedMsg, "შეცდომა ტექსტის შედარებისას");
    }


    public void clickToHome() {
        utils.clickToHomeBtn();
    }


    public void useDefaultKeys() throws IOException, InterruptedException {


        // https://appium.readthedocs.io/en/latest/en/commands/mobile-command/
        //  driver.executeScript("mobile: pressButton", ImmutableMap.of("name", "home"));

        // driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));

        //        ProcessBuilder pb = new ProcessBuilder("adb", "-s", "emulator-5554", "shell","am", "force-stop", "com.swaglabsmobileapp");
        //        pb.redirectErrorStream(true);
        //        Process p = pb.start();
        //        p.waitFor();

    }


}

