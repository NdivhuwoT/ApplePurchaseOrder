package PageObjects;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text() = 'Login']")
    WebElement LoginButton;

    @FindBy(id = "login-email")
    WebElement EmailField;

    @FindBy(id = "login-password")
    WebElement PasswordField;

    @FindBy(id = "login-submit")
    WebElement LoginSubmitButton;

    @FindBy(xpath = "//span[text() = 'My Learning']")
    WebElement MyLearningButton;

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
        LoginButton.click();
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(EmailField));
        EmailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(PasswordField));
        PasswordField.sendKeys(password);
    }

    public void clickLoginSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginSubmitButton));
        LoginSubmitButton.click();
    }

    public void verifySuccessfullLogin() {
        wait.until(ExpectedConditions.visibilityOf(MyLearningButton));
        if (!MyLearningButton.isDisplayed()) {
            throw new AssertionError("Login was not successful. 'My Learning' button is not visible.");
        }
    }

}
