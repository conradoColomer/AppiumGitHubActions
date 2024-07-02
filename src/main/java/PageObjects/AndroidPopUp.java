package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AndroidPopUp extends PageBase{
    public AndroidPopUp(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "android:id/button2")
    MobileElement noThanksBtn;

//    using +1 ways of finding an element In this case. Xpath is found first
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button3\"]")
    @AndroidFindBy (id ="android:id/button3")
    MobileElement laterBtn;
    @AndroidFindBy (id= "android:id/button1")
    MobileElement rateNowBtn;

   public void clickDeny (){
       click(noThanksBtn);
   }

   public void clickLater () {
     String att =   laterBtn.getAttribute("package");
     System.out.println(att);

       click(laterBtn);
   }

   public void clickRateNow() {
       click(rateNowBtn);
    }

    public boolean isLaterBtnDisplayed() {
        try {
            return laterBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }



}



