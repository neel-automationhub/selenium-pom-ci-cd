import Home.HomePage;
import Home.PracticeDashboard;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;

public class PracticeDashboardTest extends Base {

    public WebDriver driver;
    PracticeDashboard practiceDashboard;
    HomePage homePage;

    @BeforeTest
    public void setUp() throws IOException {
        driver= initializeDriver();
        homePage = new HomePage(driver);
        practiceDashboard = new PracticeDashboard(driver);
        driver.get("https://rahulshettyacademy.com/#/practice-project");
    }

    @Test(priority = 0)
    public void goToDashboard() {
        System.out.println("goToDashboard() Method Called Successfully");
        /*homePage.enterName("test");
        homePage.enterEmail("demo@gmail.com");
        homePage.selectAgreeTermsCheckbox();
        homePage.submitForm();
        practiceDashboard.getClick();*/
    }


    /*@Test(priority = 1, dependsOnMethods = {"goToDashboard"})
    @Parameters({"info"})
    public void failedTestCase(String value) {
        Assert.assertFalse(practiceDashboard.isDisplayed());
    }*/

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
