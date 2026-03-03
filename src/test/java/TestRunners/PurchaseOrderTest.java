package TestRunners;

import Base.BaseTest;
import org.testng.annotations.Test;

public class PurchaseOrderTest extends BaseTest {

    @Test
    public void loginWithValidCred(){
        loginPage.clickLoginButton();
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.clickLoginSubmitButton();
        loginPage.verifySuccessfullLogin();
    }
}
