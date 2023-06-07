package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {

    WebDriver driver;

    public WebDriver initializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//config.properties");
        //FileInputStream inputStream = new FileInputStream("\");
        prop.load(inputStream);

        // System.getProperty("browser") used for run time execution - mvn test -Dbrowser = firefox
        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");

        //String browser = prop.getProperty("browser");

        if (browser.contains("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver();
            if (browser.contains("headless")) {
                chromeOptions.addArguments("headless");
            }
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().setSize(new Dimension(1440, 900)); // Once we set this then it will override the maximize mode in headless settings. This will be used when elements not found
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public String takeScreenShotAs(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        String destinationPath = System.getProperty("user.dir") + "//reports//" + testCaseName + ".PNG";
        FileUtils.copyFile(file, new File(destinationPath));
        return destinationPath;
    }

}
