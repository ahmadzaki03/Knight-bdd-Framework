package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.function.BinaryOperator;
public class BaseSetup {
    private static WebDriver driver;

    public void openBrowser() {
        //Steps to read a property file
        //Step 1) the absolute file path to the property file.
        String configFilePath = System.getProperty("user.dir") + "/src/test/resources/configs/qa_env_config.properties";

        //Step 2) Create Object from Properties Class in Java Library.
        Properties properties = new Properties();

        //Step 3) Load config file to properties object.
        // we need FileInputStream file Java.
        try {
            FileInputStream configFile = new FileInputStream(configFilePath);
            properties.load(configFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Step 4) read a value from property file using the property key.
        String baseUrl = properties.getProperty("ui.url");
        String browserType = properties.getProperty("ui.browser.type");


        if (browserType.equalsIgnoreCase("chrome")) {
            //Add headless option to Chrome browser
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Wrong Browser Type");
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(baseUrl);
    }

    public void driverQuit() {
        if (driver != null)
            driver.quit();
    }

    //Ready only Getter to read get Driver instance.
    //Java Encapsulation Concept.
    public WebDriver getDriver() {
        return driver;
    }

}
