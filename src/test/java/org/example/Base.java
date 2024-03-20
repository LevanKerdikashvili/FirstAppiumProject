package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Base {

    public static AndroidDriver driver;

    public static Config conf = Config.getInstance();



    @BeforeSuite
    public static void setUp() throws MalformedURLException {


  //      String username;
 //       String password;

//        if (Objects.equals(conf.read("device"), "phone")) {
//            username = conf.read("usernameForPhone");
//            password = conf.read("passwordForPhone");
//
//        } else {
//            username = conf.read("usernameForPhone2");
//            password = conf.read("passwordForPhone2");
//        }


        System.out.println("დავიწყე კავშირის დამყარება");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("appium:automationName", "UiAutomator2"); // განვსაზღრეთ დრაივერის ტიპი.
        cap.setCapability("appium:udid", conf.read("udid")); // განვსაზღრეთ  მოწყობილობა
        cap.setCapability("appium:appPackage", conf.read("appPackage")); // განვსაზღრეთ აპლიკაციის ფექიჯის სახელი
        cap.setCapability("appium:appActivity", conf.read("appActivity")); // განვსაზღრეთ აპლიკაციის ექთივითი

        cap.setCapability("appium:skipUnlock", true); // მოვხსენით ბლოკი
        cap.setCapability("appium:noReset", true); // რესეთისგან თავის აცილება.
        cap.setCapability("appium:autoGrantPermissions", true); //  წვდომების მიცემა შესაბამის მოთხოვნებზე
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
        System.out.println("დავასრულე დრაივერის გამართვა");
    }



    @AfterSuite
    public void tearDown() {

        System.out.println("დავიწყე დრაივერის შემოწმება");
        if (driver != null) {
            System.out.println("დავიწყე დრაივერის გაუქმება");
            driver.quit(); // ხურავს დრაივერს.
            System.out.println("დრაივერი გაუქმებულია");
        }

    }


}
