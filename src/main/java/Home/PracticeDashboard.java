package Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeDashboard {

    public WebDriver driver;

    @FindBy(xpath = "//h5[text()='OUR PROJECTS']")
    WebElement project;

    @FindBy(xpath = "//a[text() = 'Automation Practise - 1']")
    WebElement automationProject;

    @FindBy(xpath = "//div[text() = 'GREEN']")
    WebElement green;

    public PracticeDashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getText() {
        return project.getText();
    }

    public void getClick() {
        automationProject.click();
    }

    public boolean isDisplayed() {
        return green.isDisplayed();
    }

}
