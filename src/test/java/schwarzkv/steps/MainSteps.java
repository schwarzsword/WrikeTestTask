package schwarzkv.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import schwarzkv.pages.MainPage;

public class MainSteps {
    private MainPage page;
    private WebDriver driver;
    private static final String WRIKE_URL = "https://www.wrike.com/";
    private static final String ICON_URL = "content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v2#twitter";
    private static final String RESEND_URL = "https://www.wrike.com/resend/";
    private static final String TWITTER_URL = "https://twitter.com/wrike";
    private static final String SVG = "M14.2 3.2v.42A9.23 9.23 0 0 1-.01 11.39a6.66 6.66 0 0 0 .78 0 6.5 6.5 0 0 0 4-1.38 3.25 3.25 0 0 1-3-2.25 4.21 4.21 0 0 0 .61 0 3.42 3.42 0 0 0 .85-.11 3.24 3.24 0 0 1-2.6-3.18 3.27 3.27 0 0 0 1.47.41 3.25 3.25 0 0 1-1-4.34 9.22 9.22 0 0 0 6.69 3.39 3.66 3.66 0 0 1-.08-.74A3.25 3.25 0 0 1 13.32.97a6.39 6.39 0 0 0 2.06-.78 3.23 3.23 0 0 1-1.43 1.79 6.5 6.5 0 0 0 1.87-.5A7 7 0 0 1 14.2 3.2z";
    private static final String ICON_FILL = "#3b7ed5";
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
