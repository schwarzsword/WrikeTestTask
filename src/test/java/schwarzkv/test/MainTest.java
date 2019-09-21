package schwarzkv.test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import schwarzkv.config.browser.ChromeConfig;
import schwarzkv.steps.MainSteps;
import schwarzkv.steps.SurveySteps;
import schwarzkv.util.StringGenerator;

public class MainTest {

    private WebDriver driver;
    private MainSteps mainSteps;
    private SurveySteps surveySteps;
    private String email;
    private static final String POSTFIX = "+wpt@wriketask.qaa";

    @Before
    public void prepare() {
        driver = ChromeConfig.ChromeDriver();
        mainSteps = new MainSteps(driver);
        surveySteps = new SurveySteps(driver);
        email = StringGenerator.generate() +  POSTFIX;
    }


    @Test
    @DisplayName("Email and Q&A test")
    @Description("Check working email submission and redirect. Check working of survey")
    @Epic("Wrike test task")
    @Feature("Test case 1")
    @Story("Email and Q&A test")
    public void emailAndSurveyTest() {
        mainSteps
                .openMain()
                .clickGetStarted()
                .typeEmail(email)
                .submitEmail();
        surveySteps
                .setAnswers()
                .submitSurvey()
                .checkSuccess();
    }


    @After
    public void quit() {
        driver.quit();
    }

}
