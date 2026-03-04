package TestRunners;

import Base.BaseTest;
import Utilities.ReadXSLData;
import org.testng.annotations.Test;

public class PurchaseOrderTest extends BaseTest {

    @Test( dataProviderClass = ReadXSLData.class, dataProvider = "Credential")
    public void loginWithValidCred(String username, String password) {
        loginPage.clickLoginButton();
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginSubmitButton();
        loginPage.verifySuccessfullLogin();
    }

    @Test(dataProviderClass =  ReadXSLData.class, dataProvider = "InventoryData")
    public void inventoryForm(String deviceType, String brand, String storage, String color, int quantity, String address) {
        inventoryFormPage.clickLearnButton();
        inventoryFormPage.clickLearnMaterialButton();
        inventoryFormPage.verifyInventoryForm();
        inventoryFormPage.chooseDeviceType(deviceType);
        inventoryFormPage.chooseBrand(brand);
        inventoryFormPage.chooseStorage(storage);
        inventoryFormPage.chooseColor(color);
        inventoryFormPage.enterQuantity(quantity);
        inventoryFormPage.enterAddress(address);
        inventoryFormPage.clickInventoryNextButton();
    }
}
