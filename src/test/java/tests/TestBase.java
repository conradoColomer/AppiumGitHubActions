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

    public static void iOS_setUp(String port, String deviceName,
                                 String platformVersion,
                                 String UDID,
                                 String wdaLocalPort) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/apps/DailyCheck.app");
        capabilities.setCapability("wdaLocalPort", wdaLocalPort);
        capabilities.setCapability("udid", UDID);
        driver = new IOSDriver(new URL("http://localhost:" + port + "/"), capabilities);
    }

    public static void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }



}
