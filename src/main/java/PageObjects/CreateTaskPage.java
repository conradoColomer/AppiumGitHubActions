package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CreateTaskPage extends  PageBase{
    public CreateTaskPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    //First we locate the elements
    @AndroidFindBy(id = "editTextTitre")
    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Title'") //other way of finding. We see this on the inspector
    MobileElement titleInput;

    @AndroidFindBy(id = "editTextNote")
    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Description'")
    MobileElement noteInput;

    @AndroidFindBy(id = "editTextTag")
    MobileElement tagInput;

    @AndroidFindBy (id = "action_save")
    @iOSXCUITFindBy(accessibility = "Save")
    MobileElement saveBtn;

    //We then create the void to use in the example for each element of the page
    public void enterTaskName(String taskName) {
//        titleInput.clear();
        clear(titleInput);
        sendText(titleInput, taskName);

    }

    public void enterNoteDesc (String noteDesc) {
        clear(noteInput);
        sendText(noteInput, noteDesc);

    }

    public void enterTagDesc (String tagDesc) {
        clear(tagInput);
        sendText(tagInput, tagDesc);

    }

    public void clickSaveBtn () {
        click(saveBtn);

    }
}

