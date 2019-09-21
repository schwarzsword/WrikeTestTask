package schwarzkv.config.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeConfig {
    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    }
    public static WebDriver ChromeDriver() {
        return new ChromeDriver();
    }
}
