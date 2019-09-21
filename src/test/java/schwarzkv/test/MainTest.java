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
import schwarzkv.steps.FirstSteps;
import schwarzkv.util.MailGenerator;

public class MainTest {

    private WebDriver driver;
    private FirstSteps firstSteps;
    private String email;

    @Before
    public void prepare() {
        driver = ChromeConfig.ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        firstSteps = new FirstSteps(driver, js);
        email = MailGenerator.generate();
    }


    @Test
    @DisplayName("Get started functionality test")
    @Description("Email validation. Q&A test")
    @Epic("Wrike site test")
    @Feature("Free trial")
    @Story("Form submission")
    public void getStartedTest() {
        firstSteps
                .openMain()
                .clickGetStarted()
                .typeEmail(email)
                .submitEmail();
    }


    @After
    public void quit() {
        driver.quit();
    }

}
