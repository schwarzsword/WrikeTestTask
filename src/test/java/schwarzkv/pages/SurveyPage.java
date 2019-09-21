package schwarzkv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SurveyPage extends Page {
    public SurveyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class,'survey-form')]//*[contains(@class,'switch__button')]")
    public List<WebElement> options;

    @FindBy(xpath = "//input[contains(@type,'text')]")
    public WebElement otherInput;

    @FindBy(xpath = "//*[contains(@class,'js-survey-submit')]")
    public WebElement surveySubmit;

    @FindBy(xpath = "//*[contains(@class,'survey-success')]")
    public WebElement message;


}
