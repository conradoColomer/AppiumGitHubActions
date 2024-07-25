package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.NoSuchElementException;

public class TaskListPage  extends PageBase{
    public TaskListPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "fab")
    @iOSXCUITFindBy(accessibility = "plus.circle")
    MobileElement addTaskBtn; //One mobile element working with both OS

//    This depends of the X number of cards created
    @AndroidFindBy(xpath = "//android.widget.ListView[@resource-id=\"com.jeffprod.todo:id/lv\"]/android.widget.RelativeLayout[1]")
    @iOSXCUITFindBy( )
    MobileElement first_card_created; //One mobile element working with both OS

//    Need to be worked
//    public void ignore_taskListPage(String tagForCheck) {
//        try {
//            waitForVisibility(first_card_created);
//            ignore_region(tagForCheck, first_card_created);
//        } catch (NoSuchElementException e) {
//            System.out.println("Element not found: " + e.getMessage());
//        }
//    }

    public void clickAddTaskBtn(){

        click(addTaskBtn);
    }



}
