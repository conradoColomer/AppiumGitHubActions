package tests;

import PageObjects.CreateTaskPage;
import PageObjects.TaskListPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class ToDo_iOS extends TestBase{
    CreateTaskPage createTaskPage; // instancio clase de src/java/PageObjects.CreateTaskPage
    TaskListPage taskListPage; // instancio clase de src/java/PageObjects.TaskListPage


    @BeforeMethod
    public void setUp() {
        try {
            iOS_setUp();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    @DataProvider(name = "tasks data")
    public Object [] [] passData() throws IOException, ParseException {
        return JsonReader.getJSONData(System.getProperty("user.dir") + "/data/TaskData.json"
                , "Tasks Data", 2 );
    }

    @Test (dataProvider =  "tasks data")
    public void add_task_action (String taskName, String taskDesc) throws MalformedURLException {

        createTaskPage = new CreateTaskPage(driver);
        taskListPage = new TaskListPage(driver);


        taskListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterNoteDesc(taskDesc);
        createTaskPage.clickSaveBtn();
        driver.hideKeyboard();


    }
    
    
//New test in chap 4. Looking up how to run in parallel 
    @Test (dataProvider =  "tasks data")
    public void add_task_action_2 (String taskName, String taskDesc) throws MalformedURLException {

        createTaskPage = new CreateTaskPage(driver);
        taskListPage = new TaskListPage(driver);


        taskListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterNoteDesc(taskDesc);
        createTaskPage.clickSaveBtn();
        driver.hideKeyboard();


    }


    @AfterMethod
    public void tears_ßDown() {
      tearDown();
   }



}
