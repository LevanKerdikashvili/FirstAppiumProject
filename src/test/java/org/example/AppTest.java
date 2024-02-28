package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppTest {
    public static AndroidDriver driver;


    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        setUp(); // ვქმნით დრაივერს.
        positive();
        tearDown(); // ვხურავთ დრაივერს
    }



    public static void positive() throws InterruptedException {
        auth("standard_user", "secret_sauce");
        Thread.sleep(3000);
        WebElement productTitle = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView"));

        String successMsg = "PRODUCTS";

        if(productTitle.getText().equals(successMsg)) {
            System.out.println("#############");
            System.out.println("ავტორიზაცია წარმატებულია");
            System.out.println("#############");
        } else {
            System.out.println("#############");
            System.out.println("ავტორიზაცია ვერ მოხერხდა");
            System.out.println("#############");

        }



        //System.out.println("შეცდომის ტექსტი არის ეს: " + errMsg.getText());

       // String expectedErrMsg = "Username and password do not match any user in this service.";



    }




//    public static void negativeAuth() throws InterruptedException {
//        auth("arasworimomxamreadsafsgfd", "aerawsdfhsaesdfshsasdfa");
//        WebElement errMsg = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView"));
//
//        System.out.println("შეცდომის ტექსტი არის ეს: " + errMsg.getText());
//
//        String expectedErrMsg = "Username and password do not match any user in this service.";
//
//        if(expectedErrMsg.equals(errMsg.getText())) {
//            System.out.println("ტესტ ქეისი წარმატებულია");
//        } else {
//            System.out.println("ტესტ ქეისი წარუმატებელია :( ");
//        }
//
//    }


    public static void auth(String user, String pass) throws InterruptedException {
        Thread.sleep(3000);  // დაველოდოთ 3 წამით აპლიკაციის ჩართვას.

        WebElement usernameField = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]"));
        WebElement passwordField = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]"));
        WebElement loginBtn = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]"));


        usernameField.clear();
        usernameField.sendKeys(user);

        passwordField.clear();
        passwordField.sendKeys(pass);

        loginBtn.click();

    }


    /*
    ეს მეთოდი გამოიყენება აპიუმთან კავშირისთვის.
     */
    public static void setUp() throws MalformedURLException {
        System.out.println("დავიწყე კავშირის დამყარება");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("appium:automationName", "UiAutomator2"); // განვსაზღრეთ დრაივერის ტიპი.
        cap.setCapability("appium:udid", "emulator-5554"); // განვსაზღრეთ  მოწყობილობა
        cap.setCapability("appium:appPackage", "com.swaglabsmobileapp"); // განვსაზღრეთ აპლიკაციის ფექიჯის სახელი
        cap.setCapability("appium:appActivity", "com.swaglabsmobileapp.SplashActivity"); // განვსაზღრეთ აპლიკაციის ექთივითი
        cap.setCapability("appium:skipUnlock", true); // მოვხსენით ბლოკი
        cap.setCapability("appium:noReset", true); // რესეთისგან თავის აცილება.
        cap.setCapability("appium:autoGrantPermissions", true); //  წვდომების მიცემა შესაბამის მოთხოვნებზე
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
        System.out.println("დავასრულე დრაივერის გამართვა");
    }


    /*
    აუქმებს დრაივერს თუ ის არსებობს.
     */
    public static void tearDown() {


        System.out.println("დავიწყე დრაივერის შემოწმება");
        if (driver != null) {
            System.out.println("დავიწყე დრაივერის გაუქმება");
            driver.quit(); // ხურავს დრაივერს.
            System.out.println("დრაივერი გაუქმებულია");
        }
    }


}
