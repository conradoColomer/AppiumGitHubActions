package PageObjects;

import com.applitools.eyes.appium.Eyes;
import com.applitools.eyes.appium.Target;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    AppiumDriver driver;
    public static final long WAIT = 25;

    public PageBase(AppiumDriver appiumDriver){ // Constructor
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        driver = appiumDriver;
    }

    public void waitForVisibility(MobileElement element){
        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clear(MobileElement element){
        waitForVisibility(element);
        element.clear();

    }

    public void click(MobileElement element){
        waitForVisibility(element);
        element.click();

    }

    public void sendText (MobileElement element, String text){
        waitForVisibility(element);
        element.sendKeys(text);

    }

//    Need to be worked
//    public void ignore_region (String tagForVisualCheck , MobileElement element) {
//        Eyes ey = new Eyes();
//        ey.check(tagForVisualCheck, Target.window().ignore(element));
//    }

    public String  getAttribute(MobileElement element, String attribute){
       waitForVisibility(element);
    return element.getAttribute(attribute);


    }
}
