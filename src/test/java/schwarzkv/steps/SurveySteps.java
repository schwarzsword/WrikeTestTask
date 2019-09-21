package schwarzkv.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import schwarzkv.pages.SurveyPage;
import schwarzkv.util.StringGenerator;

import java.util.Random;

public class SurveySteps {
    private SurveyPage page;
    private WebDriver driver;
    private static final int TIMEOUT = 5;


    public SurveySteps(WebDriver driver) {
        this.driver = driver;
        page = new SurveyPage(this.driver);
    }

    @Step("5. Fill the survey")
    public SurveySteps setAnswers() {
        Random random = new Random();
        page.options.get(random.nextInt(2)).click();
        page.options.get(random.nextInt(5) + 2).click();
        page.options.get(random.nextInt(3) + 7).click();
        if (page.otherInput.isDisplayed())
            page.otherInput.sendKeys(StringGenerator.generate());
        return this;
    }

    @Step("6. Submit the survey")
    public SurveySteps submitSurvey() {
        page.surveySubmit.click();
        return this;
    }

    @Step("7. Check if submit is successful")
    public SurveySteps checkSuccess() {
        new WebDriverWait(driver, TIMEOUT)
                .withMessage("Submit failed")
                .until(ExpectedConditions.visibilityOf(page.message));
        return this;
    }


}
