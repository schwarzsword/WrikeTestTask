package schwarzkv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstPage extends Page{

    public FirstPage(WebDriver driver) {
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

//    @FindBy(xpath = "//*[contains(@class,'wg-footer__social-item']")
//    public WebElement buttonTwitter;
//
//    @FindBy(xpath = "//*[contains(@d,'wg-footer__social-icon']")
//    public WebElement imgTwitter;


}
