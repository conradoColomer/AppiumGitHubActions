package tests;

import PageObjects.AndroidPopUp;
import PageObjects.CreateTaskPage;
import PageObjects.PageBase;
import PageObjects.TaskListPage;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.appium.Eyes;
import com.applitools.eyes.appium.Target;
import io.appium.java_client.MobileElement;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.expression.MethodBasedEvaluationContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class ToDo_Android extends TestBase {

    CreateTaskPage createTaskPage; // instancio clase de src/java/PageObjects.CreateTaskPage
    TaskListPage taskListPage; // instancio clase de src/java/PageObjects.TaskListPage
    AndroidPopUp androidPopUp;

//    Regions with Applitools
    String APP_NAME = "ToDo";
    String FLOATING_REGION_TEST = "Floating region ignore";
    String STRICT_REGION_TEST = "Strict region ignore";
    String CONTENT_REGION_TEST = "Content region ignore";
    String LAYOUT_REGION_TEST = "Layout region ignore";

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
        if (androidPopUp.idDisplayedHandMade()) {
        androidPopUp.clickLater();
        } else {
        taskListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterNoteDesc(taskDesc);
        driver.hideKeyboard();
        createTaskPage.clickSaveBtn();}

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


//    COMMON VISUAL CHECK

    @Test
    public void visualCheckInitialScreen () throws MalformedURLException {
        String appName = "ToDo";
        String testName  = "Visual Tests E2E";

        Android_setUp(); // We can call it because is a PUBLIC STATIC VOID
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
//       Creating Android prerequisite = avoid the Android popup
        androidPopUp = new AndroidPopUp(driver);
        if (androidPopUp.idDisplayedHandMade()){
            androidPopUp.clickLater();} else {
            initAppliToolsEyes(appName,testName);
            eyes.checkWindow("Create task page");
            taskListPage.clickAddTaskBtn();
            createTaskPage.enterTaskName("taskName Conrado Mendez Colomer ");
            createTaskPage.enterNoteDesc("taskDesc We are trying to run CIIIIII ");
            eyes.checkWindow("Task list input");
            driver.hideKeyboard();
            createTaskPage.clickSaveBtn();}
        eyes.checkWindow("initial screen with Task display");

        tearDown();

    }

//      IGNORE REGIONS with NEW_TASK_NAME & NEW_TASK_DESC
    @Test
    public void visualCheck_IgnoreRegions () throws MalformedURLException {


        String appName = "ToDo";
        String testName  = "Visual Tests E2E"; //Batch name ====> see a way to improve
        String NEW_TASK_NAME = "Manuela Gonzalez Bergez";
        String NEW_TASK_DESC = "Corriendo pruebas con Applitools";


        Android_setUp(); // We can call it because is a PUBLIC STATIC VOID
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);

        androidPopUp = new AndroidPopUp(driver);
        if (androidPopUp.idDisplayedHandMade()){
            androidPopUp.clickLater();} else {

//            Starting applitools eyes
            initAppliToolsEyes_LAYOUT(appName,testName);

            taskListPage.clickAddTaskBtn();
            createTaskPage.enterTaskName(NEW_TASK_NAME);
            createTaskPage.enterNoteDesc(NEW_TASK_DESC);
            driver.hideKeyboard();
            createTaskPage.clickSaveBtn();}

        // Esperar hasta que el elemento esté presente
        WebDriverWait wait = new WebDriverWait(driver, 25);
        MobileElement ignoringRegion = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ListView[@resource-id=\"com.jeffprod.todo:id/lv\"]/android.widget.RelativeLayout[1]")));

        // Agregar una verificación visual ignorando una región específica
        eyes.check(testName, Target.window().ignore(ignoringRegion));


        tearDown();

    }

    //     IGNORE REGIONS in a general view. not specific locator.
    @Test
    public void visualCheck_IgnoreRegions_GeneralView () throws MalformedURLException, InterruptedException {


        String appName = "ToDo";
        String testName  = "Visual Tests E2E"; //Batch name ====> see a way to improve
        String NEW_TASK_NAME = "aaaaaa aaa con";
        String NEW_TASK_DESC = "P{aaaa con aaa geneaadfgfdsdfdsral";


        Android_setUp(); // We can call it because is a PUBLIC STATIC VOID
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);

        androidPopUp = new AndroidPopUp(driver);
        if (androidPopUp.idDisplayedHandMade()){
            androidPopUp.clickLater();} else {

//            Starting applitools eyes
            initAppliToolsEyes_LAYOUT(appName,testName);

            taskListPage.clickAddTaskBtn();
            createTaskPage.enterTaskName(NEW_TASK_NAME);
            createTaskPage.enterNoteDesc(NEW_TASK_DESC);
            driver.hideKeyboard();
            createTaskPage.clickSaveBtn();}

//        // Esperar hasta que el elemento esté presente
//        WebDriverWait wait = new WebDriverWait(driver, 25);
//        MobileElement ignoringRegion = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ListView[@resource-id=\"com.jeffprod.todo:id/lv\"]/android.widget.RelativeLayout[1]")));

        // Agregar una verificación visual ignorando una región específica
        eyes.checkWindow(testName);

        Thread.sleep(30000);


        tearDown();

    }

    //      IGNORE REGIONS with NEW_TASK_NAME & NEW_TASK_DESC
    @Test
    public void visualCheck_IgnoreRegions_waysOf () throws MalformedURLException {


        String appName = "ToDo";
        String testName  = "Visual Tests E2E"; //Batch name ====> see a way to improve
        String NEW_TASK_NAME = "Manuela Gonzalez Bergez";
        String NEW_TASK_DESC = "Corriendo pruebas con Applitools";


        Android_setUp(); // We can call it because is a PUBLIC STATIC VOID
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);

        androidPopUp = new AndroidPopUp(driver);
        if (androidPopUp.idDisplayedHandMade()){
            androidPopUp.clickLater();} else {

//            Starting applitools eyes
            initAppliToolsEyes_LAYOUT(appName,testName);

            taskListPage.clickAddTaskBtn();
            createTaskPage.enterTaskName(NEW_TASK_NAME);
            createTaskPage.enterNoteDesc(NEW_TASK_DESC);
            driver.hideKeyboard();
            createTaskPage.clickSaveBtn();

        // Esperar hasta que el elemento esté presente
        WebDriverWait wait = new WebDriverWait(driver, 25);
        MobileElement ignoreRegion1 = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ListView[@resource-id=\"com.jeffprod.todo:id/lv\"]/android.widget.RelativeLayout[1]")));
        MobileElement ignoreRegion2 = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ListView[@resource-id=\"com.jeffprod.todo:id/lv\"]/android.widget.RelativeLayout[1]")));
        MobileElement ignoreRegion3 = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ListView[@resource-id=\"com.jeffprod.todo:id/lv\"]/android.widget.RelativeLayout[1]")));


//       Ways of finding an element for ignoring
//
//        driver.findelement....
        eyes.check(testName, Target.window().ignore(driver.findElement(By.xpath("asdfg"))));

//      multiple Elements
        eyes.check(testName, Target.window().ignore(ignoreRegion1, ignoreRegion2, ignoreRegion3));



        tearDown();

    }



}
//        FLOATING REGION

public void floatingRegionTest () throws MalformedURLException {

    Android_setUp(); // We can call it because is a PUBLIC STATIC VOID
    taskListPage = new TaskListPage(driver);
    createTaskPage = new CreateTaskPage(driver);

    androidPopUp = new AndroidPopUp(driver);
    if (androidPopUp.idDisplayedHandMade()){
        androidPopUp.clickLater();} else {

//            Starting applitools eyes
        initAppliToolsEyes_LAYOUT(APP_NAME,FLOATING_REGION_TEST);

        taskListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName(APP_NAME);
        createTaskPage.enterNoteDesc(FLOATING_REGION_TEST);
        driver.hideKeyboard();
        createTaskPage.clickSaveBtn();

        // Esperar hasta que el elemento esté presente
        WebElement floatingElement = driver.findElement(By.xpath("WRITE XPATH HERE"));

        eyes.check(FLOATING_REGION_TEST, Target.window().floating(floatingElement, 10,10,10,10));

    }

}

//      STRICT REGION

    public void strictRegionTest () throws MalformedURLException {

        Android_setUp(); // We can call it because is a PUBLIC STATIC VOID
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);

        androidPopUp = new AndroidPopUp(driver);
        if (androidPopUp.idDisplayedHandMade()){
            androidPopUp.clickLater();} else {

//            Starting applitools eyes
            initAppliToolsEyes_LAYOUT(APP_NAME,STRICT_REGION_TEST);

            taskListPage.clickAddTaskBtn();
            createTaskPage.enterTaskName(APP_NAME);
            createTaskPage.enterNoteDesc(STRICT_REGION_TEST);
            driver.hideKeyboard();
            createTaskPage.clickSaveBtn();

            // Esperar hasta que el elemento esté presente
            WebElement strictCheckElement= driver.findElement(By.xpath("WRITE XPATH HERE"));

            eyes.check(STRICT_REGION_TEST, Target.window().strict(strictCheckElement));

        }

    }

//    CONTENT REGION

    public void contentRegionTest () throws MalformedURLException {

        Android_setUp(); // We can call it because is a PUBLIC STATIC VOID
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);

        androidPopUp = new AndroidPopUp(driver);
        if (androidPopUp.idDisplayedHandMade()){
            androidPopUp.clickLater();} else {

//            Starting applitools eyes
            initAppliToolsEyes_LAYOUT(APP_NAME, CONTENT_REGION_TEST );

            taskListPage.clickAddTaskBtn();
            createTaskPage.enterTaskName(APP_NAME);
            createTaskPage.enterNoteDesc(CONTENT_REGION_TEST );
            driver.hideKeyboard();
            createTaskPage.clickSaveBtn();

            // Esperar hasta que el elemento esté presente
            WebElement contentCheckElement= driver.findElement(By.xpath("WRITE XPATH HERE"));

            eyes.check(CONTENT_REGION_TEST , Target.window().content(contentCheckElement, driver.findElement(By.xpath("qw"))));


        }


    }

//    LAYOUT REGION

    public void layoutRegionTest () throws MalformedURLException {

        Android_setUp(); // We can call it because is a PUBLIC STATIC VOID
        taskListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);

        androidPopUp = new AndroidPopUp(driver);
        if (androidPopUp.idDisplayedHandMade()){
            androidPopUp.clickLater();} else {

//            Starting applitools eyes
            initAppliToolsEyes_LAYOUT(APP_NAME,  LAYOUT_REGION_TEST );

            taskListPage.clickAddTaskBtn();
            createTaskPage.enterTaskName(APP_NAME);
            createTaskPage.enterNoteDesc(  LAYOUT_REGION_TEST);
            driver.hideKeyboard();
            createTaskPage.clickSaveBtn();

            // Esperar hasta que el elemento esté presente
            WebElement layoutCheckElement= driver.findElement(By.xpath("WRITE XPATH HERE"));

            eyes.check(LAYOUT_REGION_TEST  , Target.window().layout(layoutCheckElement, driver.findElement(By.xpath("qw"))));


        }


    }



}

