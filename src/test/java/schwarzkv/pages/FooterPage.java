package schwarzkv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterPage extends Page {
    FooterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//*[@class='wg-footer__social-link'])[1]")
    private WebElement twitterSection;

    @FindBy(xpath = "(//*[@class='wg-footer__social-link'])[1]/*[name()='svg']/*[name()='use']")
    private WebElement twitterIconReference;
}
