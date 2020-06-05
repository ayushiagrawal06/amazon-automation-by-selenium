package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class DriverUtils {

    public static  WebDriver _driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        _driver = new ChromeDriver();
    }

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver","src" +
                File.separator + "test" + File.separator + "resources" + File.separator + "chromedriver.exe");
        if ( _driver == null) {
            _driver = new ChromeDriver();
        }
        return _driver;
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        _driver.close();
        _driver.quit();
    }
}
