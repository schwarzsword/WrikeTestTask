package schwarzkv.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import schwarzkv.pages.SurveyPage;

import java.util.Random;

import static schwarzkv.config.Properties.TIMEOUT;

public class SurveySteps {
    private SurveyPage page;
    private WebDriver driver;


    public SurveySteps(WebDriver driver) {
        this.driver = driver;
        page = new SurveyPage(this.driver);
    }


    @Step("Fill the survey")
    public SurveySteps setAnswers(String msg) {
        Random random = new Random();
        page.options.get(random.nextInt(2)).click();
        page.options.get(random.nextInt(5) + 2).click();
        page.options.get(random.nextInt(3) + 7).click();
        if (page.otherInput.isDisplayed()) {
            page.otherInput.sendKeys(msg);
        }
        return this;
    }

    @Step("Submit the survey")
    public SurveySteps submitSurvey() {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(page.surveySubmit));
        page.surveySubmit.click();
        return this;
    }

    @Step("Check if submit is successful")
    public void checkSuccess() {
        new WebDriverWait(driver, TIMEOUT)
                .withMessage("Submit failed")
                .until(ExpectedConditions.visibilityOf(page.message));
    }


}
