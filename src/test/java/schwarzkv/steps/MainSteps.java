package schwarzkv.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import schwarzkv.pages.MainPage;

public class MainSteps {
    private MainPage page;
    private WebDriver driver;
    private static final String WRIKE_URL = "https://www.wrike.com/";
    private static final String RESEND_URL = "https://www.wrike.com/resend/";
    private static final int TIMEOUT = 5;


    public MainSteps(WebDriver driver) {
        this.driver = driver;
        page = new MainPage(this.driver);
    }

    @Step("1. Open main page")
    public MainSteps openMain() {
        driver.get(WRIKE_URL);
        return this;
    }

    @Step("2. Click \"Get started for free\" button in header")
    public MainSteps clickGetStarted() {
        page.startButton.click();
        return this;
    }

    @Step("3. Type given email - {email}")
    public MainSteps typeEmail(String email) {
        page.emailInput.sendKeys(email);
        return this; //TODO сделать хорошо
    }

    @Step("4. Submit form")
    public MainSteps submitEmail() {
        page.emailSubmit.click();
        new WebDriverWait(driver, TIMEOUT)
                .withMessage("Invalid url, expecter URL is " + RESEND_URL)
                .until(ExpectedConditions.urlMatches(RESEND_URL));
        return this;
    }
}
