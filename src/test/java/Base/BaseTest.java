package Base;

import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    BrowserFactory browser = new BrowserFactory();
    public final String url = "https://ndosisimplifiedautomation.vercel.app/";
    public final String browserChoice = "chrome";

    @BeforeMethod
    public void setUpBrowser(){
        browser.startBrowser(browserChoice,url);
    }

    @AfterMethod
    public void tearDownBrowser(){
        browser.closeBrowser();
    }
}
