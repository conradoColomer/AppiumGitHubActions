package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends AbstractTestNGCucumberTests  {
    public static AppiumDriver driver;
// Hi conrad. push was right
    public static void Android_setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");

        capabilities.setCapability("platformVersion", "10");  // Ensure this matches the emulator API level

        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/apps/ToDo.apk");
        driver = new AppiumDriver(new URL("http://localhost:4723/"), capabilities);
    }

    public static void iOS_setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 15 Pro TAM");
        capabilities.setCapability("udid","E6D42DE8-62B4-4F22-B5DF-B511035585D7" );
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("isHeadless", true);
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/apps/DailyCheck.app");
        driver = new IOSDriver(new URL("http://localhost:4723/"), capabilities);
    }

    public void initAppliToolsEyes (){
//        here we can set up the applitools eyes for each test
//        we can also add as parameters the Test name / app / etc....
//        also we can add the tear
//                eyes.close
//                        eyes.abort if not closed
//        We can the initialize it befor every visual test we are going to start testing
//                and in the final method of the class then execute the other method for shooting down eyes
    }


    public static void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }



}
