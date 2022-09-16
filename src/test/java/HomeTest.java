import Home.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import resources.Base;

import java.io.IOException;

public class HomeTest extends Base {
    public WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        driver.get("https://rahulshettyacademy.com/#/practice-project");
    }

    @Test(priority = 1)
    public void launchApplication() {
        Assert.assertEquals(homePage.joinPractice.getText(), "Join now to Practice");
    }

    @Test(priority = 2)
    public void enterName() {
        homePage.enterName("Test");
        homePage.enterEmail("demo@gmail.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
