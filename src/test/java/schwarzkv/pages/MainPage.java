package schwarzkv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class,'wg-header__sticky-mainmenu')]//*[contains(@class,'wg-header__free-trial-button')]")
    public WebElement startButton;

    @FindBy(xpath = "//*[contains(@class,'wg-banner__close')]")
    public WebElement closeBanner;

    @FindBy(xpath = "//*[contains(@class,'modal-form-trial__input')]")
    public WebElement emailInput;

    @FindBy(xpath = "//*[contains(@class,'modal-form-trial__submit')]")
    public WebElement emailSubmit;

    @FindBy(xpath = "//*[1][contains(@class, 'wg-footer__social-item')]//*[contains(@class, 'wg-footer__social-link')]")
    public WebElement twitterButton;

}
