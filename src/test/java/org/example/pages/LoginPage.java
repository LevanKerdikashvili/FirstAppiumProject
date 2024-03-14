package org.example.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    protected AndroidDriver driver;
    private WebDriverWait wait;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    private WebElement username;


    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    private WebElement password;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    private WebElement loginBtn;


    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    private WebElement loginErrorMessage;


    public void fillUsernameWithPassword(String user, String pass, boolean clickToBtn) {
        wait.until(ExpectedConditions.visibilityOf(username));
        username.clear();
        username.sendKeys(user);

        wait.until(ExpectedConditions.visibilityOf(password));
        password.clear();
        password.sendKeys(pass);

        if (clickToBtn) {
            clickToLogin();
        }

    }


    public void clickToLogin() {
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        loginBtn.click();
    }


    public void checkErrorText(String expectedMsg) {
        wait.until(ExpectedConditions.visibilityOf(loginErrorMessage));
        Assert.assertEquals(loginErrorMessage.getText(), expectedMsg, "შეცდომა ტექსტის შედარებისას");
    }


}

