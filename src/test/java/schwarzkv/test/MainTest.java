package schwarzkv.test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import schwarzkv.config.browser.ChromeConfig;
import schwarzkv.steps.MainSteps;
import schwarzkv.steps.SurveySteps;

import static schwarzkv.config.Properties.POSTFIX;
import static schwarzkv.util.StringGenerator.generateRandomString;

@Epic("Wrike site test")
public class MainTest {

    private WebDriver driver;
    private MainSteps mainSteps;
    private SurveySteps surveySteps;
    private String email;
    private String otherMessage;

    @Before
    public void prepare() {
        driver = ChromeConfig.ChromeDriver();
        mainSteps = new MainSteps(driver);
        surveySteps = new SurveySteps(driver);
        email = generateRandomString(50) + POSTFIX;
        otherMessage = generateRandomString(20);
    }


    @Test
    @DisplayName("Email and Q&A test")
    @Description("Check working email submission and redirect. Check working of survey")
    @Feature("Getting started test")
    @Story("Email and Q&A test")
    public void emailAndSurveyTest() {
        mainSteps
                .openMain()
                .clickGetStarted()
                .typeEmail(email)
                .submitEmail();
        surveySteps
                .setAnswers(otherMessage)
                .submitSurvey()
                .checkSuccess();
    }

    @Test
    @DisplayName("Twitter link and data test")
    @Description("Check if button redirects to the right place and icon is correct")
    @Feature("Footer test")
    @Story("Twitter link and data test")
    public void twitterTest() {
        mainSteps
                .openMain()
                .checkLink();
        mainSteps
                .checkIcon();
    }


    @After
    public void quit() {
        driver.quit();
    }

}
