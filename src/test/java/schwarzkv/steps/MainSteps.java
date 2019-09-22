package schwarzkv.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import schwarzkv.pages.MainPage;

import static org.junit.Assert.assertEquals;
import static schwarzkv.config.Properties.*;

public class MainSteps {
    private MainPage page;
    private WebDriver driver;


    public MainSteps(WebDriver driver) {
        this.driver = driver;
        page = new MainPage(this.driver);
    }

    @Step("Open main page")
    public MainSteps openMain() {
        driver.get(WRIKE_URL);
        return this;
    }

    @Step("Click \"Get started for free\" button in header")
    public MainSteps clickGetStarted() {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(page.startButton));
        page.startButton.click();
        return this;
    }

    @Step("Type given email - {email}")
    public MainSteps typeEmail(String email) {
        page.emailInput.sendKeys(email);
        return this;
    }

    @Step("Submit form")
    public MainSteps submitEmail() {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(page.emailSubmit));
        page.emailSubmit.click();
        new WebDriverWait(driver, TIMEOUT)
                .withMessage("Invalid url, expected URL is " + RESEND_URL)
                .until(ExpectedConditions.urlMatches(RESEND_URL));
        return this;
    }

    @Step("Check if twitter button leads to wrike twitter")
    public void checkLink() {
        assertEquals(page.twitterButton.getAttribute("href"), TWITTER_URL);
    }

    @Step("Check if icon is proper")
    public void checkIcon() {
        driver.get(WRIKE_URL + ICON_URL);
        WebElement element = driver.findElement(By.xpath("//*[@id='twitter']//*[@d]"));
        assertEquals(element.getAttribute("d"), SVG);
        assertEquals(element.getAttribute("fill"), ICON_FILL);
    }
}
