package schwarzkv.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import schwarzkv.pages.MainPage;

import static schwarzkv.config.Properties.*;

public class MainSteps {
    private MainPage page;
    private WebDriver driver;


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

    @Step("1. Check if twitter button leads to wrike twitter")
    public void checkLink() {
        Assert.assertEquals(page.twitterButton.getAttribute("href"), TWITTER_URL);
    }

    @Step("2. Check if icon is proper")
    public void checkIcon() {
        driver.get(WRIKE_URL + ICON_URL);
        WebElement element = driver.findElement(By.xpath("//*[@id='twitter']//*[@d]"));
        Assert.assertEquals(element.getAttribute("d"), SVG);
        Assert.assertEquals(element.getAttribute("fill"), ICON_FILL);
    }
}
