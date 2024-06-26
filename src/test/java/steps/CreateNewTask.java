package steps;

import PageObjects.AndroidPopUp;
import PageObjects.CreateTaskPage;
import PageObjects.TaskListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.TestBase;

import java.net.MalformedURLException;

public class CreateNewTask extends TestBase {
    CreateTaskPage createTaskPage;
    TaskListPage taskListPage;
    AndroidPopUp androidPopUp;


    @Given("Click later popup")
    public void clickLaterPopup() throws MalformedURLException {
        Android_setUp();
        androidPopUp = new AndroidPopUp(driver);
        androidPopUp.clickLater();
    }

    @Given("Click Add new Task")
    public void clickAddNewTask() {


//       creating objects
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);

//      Steps of the test
        taskListPage.clickAddTaskBtn();

    }

    @Given("Enter Taskname")
    public void enterTaskname() {

        createTaskPage.enterTaskName("Task 1 with Cucumber" );

    }

    @Given("Enter TaskDesc")
    public void enterTaskDesc() {

        createTaskPage.enterNoteDesc("1st description with Cucumber");
    }

    @When("Click Save")
    public void clickSave() {

        createTaskPage.clickSaveBtn();
    }

    @Then("Task added successfully")
    public void taskAddedSuccessfully() {
        driver.hideKeyboard();
        tearDown();

    }


}
