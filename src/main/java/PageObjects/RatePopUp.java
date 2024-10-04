package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RatePopUp extends PageBase {
    public RatePopUp(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "android:id/button3")
    MobileElement laterbtn;

    //    using +1 ways of finding an element In this case. Xpath is found first
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")
    @AndroidFindBy(id = "android:id/button2")
    MobileElement noThanksbtn;

    @AndroidFindBy(id = "android:id/button1")
    MobileElement rateNowBtn;


    public void clickLaterBtnRate (){
        waitForVisibility(laterbtn);
        click(laterbtn);
    }

    public void clickNoThanksRateBtn () {
        waitForVisibility(noThanksbtn);
        click(noThanksbtn);
    }

    public void clickRateNow() {
        click(rateNowBtn);
    }

    public boolean isLaterBtnDisplayed() {
        try {
            return laterbtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean idDisplayedHandMade() {
        try {
            if (laterbtn.isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

        }

        return false;
    }
}



