package TestRunners;

import Base.BaseTest;
import Utilities.ReadXSLData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PurchaseOrderTest extends BaseTest {

    @Test( dataProviderClass = ReadXSLData.class, dataProvider = "testData")
    public void loginWithValidCred(String username, String password) {
        loginPage.clickLoginButton();
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginSubmitButton();
        loginPage.verifySuccessfullLogin();
    }
}
