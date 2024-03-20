package org.example.tests;

import io.qameta.allure.*;
import org.example.Base;
import org.example.Utils;
import org.example.pages.LoginPage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class LoginTest extends Base {


//    @Test
//    public void loginWithWrongPassword() throws IOException, InterruptedException {
//        LoginPage page = new LoginPage(driver);
//
//        //mvn clean test  -Dusername=levan -Dpassword=1122
//        //  String user = System.getProperty("username");
//        // String pass = System.getProperty("password");
//
//
//        page.fillUsernameWithPassword("wrongUsername", "12341325436546", true); // with wrong username and wrong password
//        //page.fillUsernameWithPassword("wrongUsername", "12341325436546", true); // with wrong username and wrong password
//        page.checkErrorText("Username and password do not match any user in this service.");
//        //page.useDefaultKeys();
//    }


    @Test
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(CRITICAL)
    @Owner("John Doe")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    public void loginWithLockedUser() {
        LoginPage page = new LoginPage(driver);
        page.fillUsernameWithPassword("locked_out_user", "secret_sauce", true); // with locked user and correct password
        page.simpleMethod();
        page.simpleMethod();
        page.simpleMethod();
        page.simpleMethod();
        page.simpleMethod();
        page.simpleMethod();
        page.simpleMethod();
        page.simpleMethod();
        page.clickToHome();

        //page.checkErrorText("Sorry, this user has been locked out.");
    }


}
