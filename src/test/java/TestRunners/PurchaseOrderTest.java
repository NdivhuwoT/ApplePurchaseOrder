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

    @Test(dataProviderClass =  ReadXSLData.class, dataProvider = "InventoryData", priority = 1)
    public void inventoryForm(String deviceType, String brand, String storage, String color, int quantity, String address) {
        inventoryFormPage.clickLearnButton();
        inventoryFormPage.clickLearnMaterialButton();
        inventoryFormPage.clickWebAutomationButton();
        inventoryFormPage.verifyInventoryForm();
        inventoryFormPage.selectDeviceType(deviceType);
        inventoryFormPage.selectBrand(brand);
        inventoryFormPage.chooseStorage(storage);
        inventoryFormPage.selectColor(color);
        inventoryFormPage.enterQuantity(quantity);
        inventoryFormPage.enterAddress(address);
        inventoryFormPage.clickInventoryNextButton();
    }

    @Test(dataProviderClass = ReadXSLData.class, dataProvider = "ExtraData", priority = 2)
    public void extraData(String shipping, String warranty, String discount, String purchaseConfirmation) {
        inventoryFormPage.chooseShipping(shipping);
        inventoryFormPage.chooseWarranty(warranty);
        inventoryFormPage.enterDiscountCode(discount);
        inventoryFormPage.clickConfirmPurchaseButton();
        inventoryFormPage.alertVerifySuccessfulPurchase(purchaseConfirmation);
        inventoryFormPage.clickViewInvoiceButton();
        inventoryFormPage.verifyInvoiceHistoryPage();
        inventoryFormPage.clickView();

    }
}
