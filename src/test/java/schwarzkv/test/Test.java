package schwarzkv.test;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import schwarzkv.config.browser.ChromeConfig;

public class Test {

    private WebDriver driver;

    @Before
    public void prepare() {
        driver = ChromeConfig.ChromeDriver();
    }

}
