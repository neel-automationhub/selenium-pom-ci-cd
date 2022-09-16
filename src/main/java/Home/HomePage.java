package Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;

    @FindBy(xpath = "//h2[text()='Join now to Practice']")
    public WebElement joinPractice;

    @FindBy(xpath = "//input[@id='name']")
    WebElement name;

    @FindBy(xpath = "//input[@id='email']")
    WebElement email;

    @FindBy(id = "agreeTerms")
    WebElement agreeTerms;

    @FindBy(id = "form-submit")
    WebElement submit;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterName(String pname) {
        name.sendKeys(pname);
    }

    public void enterEmail(String pemail) {
        email.sendKeys(pemail);
    }

    public void selectAgreeTermsCheckbox() {
        agreeTerms.click();
    }

    public void submitForm() {
        submit.click();
    }

}
