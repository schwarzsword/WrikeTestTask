package schwarzkv.config.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static schwarzkv.config.Properties.DRIVER_PATH;
import static schwarzkv.config.Properties.DRIVER_SYSTEM_PROPERTY;

public class ChromeConfig {
    static {
        System.setProperty(DRIVER_SYSTEM_PROPERTY, DRIVER_PATH);
    }

    public static WebDriver ChromeDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
