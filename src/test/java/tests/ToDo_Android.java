package tests;

import PageObjects.AndroidPopUp;
import PageObjects.CreateTaskPage;
import PageObjects.TaskListPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class ToDo_Android extends TestBase{

    CreateTaskPage createTaskPage; // instancio clase de src/java/PageObjects.CreateTaskPage
    TaskListPage taskListPage; // instancio clase de src/java/PageObjects.TaskListPage
    AndroidPopUp androidPopUp;


    @DataProvider(name = "tasks data")
    public Object [] [] passData() throws IOException, ParseException {
        return JsonReader.getJSONData(System.getProperty("user.dir") + "/data/TaskData.json"
                , "Tasks Data", 2 );
    }

    @Test (dataProvider =  "tasks data")
    public void test_add_task (String taskName, String taskDesc) throws MalformedURLException {

        Android_setUp(); // We can call it because is a PUBLIC STATIC VOID
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
//       Creating Android prerequisite = avoid the Android popup
        androidPopUp = new AndroidPopUp(driver);
        androidPopUp.clickLater();
        taskListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterNoteDesc(taskDesc);
        driver.hideKeyboard();
        createTaskPage.clickSaveBtn();
        tearDown();

    }

    @Test
    public void test_add_task () throws MalformedURLException {

        Android_setUp(); // We can call it because is a PUBLIC STATIC VOID
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
//       Creating Android prerequisite = avoid the Android popup
        androidPopUp = new AndroidPopUp(driver);
       if (androidPopUp.idDisplayedHandMade()){
        androidPopUp.clickLater();} else {
        taskListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName("taskName Conrado Mendez Colomer ");
        createTaskPage.enterNoteDesc("taskDesc We are trying to run CIIIIII ");
        driver.hideKeyboard();
        createTaskPage.clickSaveBtn();}

        tearDown();

    }

    @Test
    public void visualCheckInitialScreen () throws MalformedURLException {
        String appName = "ToDo";
        String testName  = "Initial Screen";

        Android_setUp(); // We can call it because is a PUBLIC STATIC VOID
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
//       Creating Android prerequisite = avoid the Android popup
        androidPopUp = new AndroidPopUp(driver);
        if (androidPopUp.idDisplayedHandMade()){
            androidPopUp.clickLater();} else {
            initAppliToolsEyes(appName,testName);
            eyes.checkWindow();
            taskListPage.clickAddTaskBtn();
            createTaskPage.enterTaskName("taskName Conrado Mendez Colomer ");
            createTaskPage.enterNoteDesc("taskDesc We are trying to run CIIIIII ");
            driver.hideKeyboard();
            createTaskPage.clickSaveBtn();}

        tearDown();

    }



}

