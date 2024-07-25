package tests;

import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.appium.Eyes;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends AbstractTestNGCucumberTests  {
    public static AppiumDriver driver;
    public static  Eyes eyes;
    static final String API_KEY = System.getenv("API_KEY");
// Hi conrad. push was right
    public static void Android_setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");

        capabilities.setCapability("platformVersion", "12");  // Ensure this matches the emulator API level

        capabilities.setCapability("deviceName", "Android_12_c");
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

    public static void initAppliToolsEyes (String appName, String testName){
        eyes = new Eyes();
        eyes.setApiKey(API_KEY);
        eyes.setForceFullPageScreenshot(true);
//        eyes.setMatchLevel(MatchLevel.LAYOUT);
        eyes.open(driver, appName,testName);
    }


    public static void initAppliToolsEyesForIgnoringRegios (String appName, String testName){
        eyes = new Eyes();
        eyes.setApiKey(API_KEY);
        eyes.setForceFullPageScreenshot(true);
        eyes.setMatchLevel(MatchLevel.LAYOUT);
        eyes.open(driver, appName,testName);
    }

    public static void tearDown() {
        // Cerrar Applitools Eyes si está presente y se ha iniciado una sesión
        if (eyes != null) {
            try {
                eyes.close();
            } catch (Exception e) {
                System.out.println("Error while closing Applitools Eyes: " + e.getMessage());
                eyes.abortIfNotClosed();
            } finally {
                eyes = null; // Limpiar la referencia
            }
        }




        if (null != driver ) {
            driver.quit();
        }
    }



}
