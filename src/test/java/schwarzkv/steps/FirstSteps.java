package schwarzkv.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import schwarzkv.pages.FirstPage;

public class FirstSteps {
    private FirstPage page;
    private WebDriver driver;
    private JavascriptExecutor jsDriver;
    private static final String WRIKE_URL = "https://www.wrike.com/";
    private static final String RESEND_URL = "https://www.wrike.com/resend/";
    private static final int TIMEOUT = 5;


    public FirstSteps(WebDriver driver, JavascriptExecutor jsDriver) {
        this.driver = driver;
        this.jsDriver = jsDriver;
        page = new FirstPage(this.driver);
    }

    @Step("1. Open main page")
    public FirstSteps openMain() {
        driver.get(WRIKE_URL);
        return this;
    }

    @Step("2. Click \"Get started for free\" button in header")
    public FirstSteps clickGetStarted() {
        page.startButton.click();
        return this;
    }

    @Step("3. Type given email - {email}")
    public FirstSteps typeEmail(String email){
        page.emailInput.sendKeys(email);
        return this; //TODO сделать хорошо
    }

    @Step("4. Submit form")
    public FirstSteps submitEmail(){
        page.emailSubmit.click();
        new WebDriverWait(driver, TIMEOUT)
                .withMessage("Invalid url")
                .until(ExpectedConditions.urlMatches(RESEND_URL));
        return this;
    }
}
