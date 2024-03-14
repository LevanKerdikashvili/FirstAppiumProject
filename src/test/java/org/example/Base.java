package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {

    public static AndroidDriver driver;



    @BeforeSuite
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


    @AfterSuite
    public  void tearDown() {
        System.out.println("დავიწყე დრაივერის შემოწმება");
        if (driver != null) {
            System.out.println("დავიწყე დრაივერის გაუქმება");
            driver.quit(); // ხურავს დრაივერს.
            System.out.println("დრაივერი გაუქმებულია");
        }
    }




}
