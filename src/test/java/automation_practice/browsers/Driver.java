package automation_practice.browsers;


import automation_practice.properties.PropertyParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;

    public static WebDriver runDriver() {

        PropertyParser propertyParser = new PropertyParser();
        String browsType = propertyParser.getProps("browser");

        if (Objects.isNull(driver)) {
            if ("Chrome".equalsIgnoreCase(browsType)) {
                System.setProperty(propertyParser.getProps("chrome_property"), propertyParser.getProps("chrome_path"));
                driver = new ChromeDriver();

            } else if ("Firefox".equalsIgnoreCase(browsType)) {
                System.setProperty(propertyParser.getProps("firefox_property"), propertyParser.getProps("firefox_path"));
                driver = new FirefoxDriver();

            } else {
                throw new RuntimeException("No such driver");
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
    }
}
