package org.example.tests;

import org.example.Base;
import org.example.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends Base {


    @Test
    public void loginWithWrongPassword() {
        LoginPage page = new LoginPage(driver);
        page.fillUsernameWithPassword("wrongUsername", "12341325436546", false); // with wrong username and wrong password
        page.checkErrorText("Username and password do not match any user in this service.");
    }


    @Test
    public void loginWithLockedUser() {
        LoginPage page = new LoginPage(driver);
        page.fillUsernameWithPassword("locked_out_user", "secret_sauce", true); // with locked user and correct password
        page.checkErrorText("Sorry, this user has been locked out.");
    }


}
