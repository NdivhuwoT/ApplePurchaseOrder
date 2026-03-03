package Base;

import PageObjects.LoginPage;
import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    BrowserFactory browser = new BrowserFactory();
    public final String url = "https://ndosisimplifiedautomation.vercel.app/";
    public final String browserChoice = "chrome";

    public WebDriver driver;
    public LoginPage loginPage;

    @BeforeClass
    public void setUpBrowser() {
        driver = browser.startBrowser(browserChoice, url);
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDownBrowser() {
        browser.closeBrowser();
    }
}
