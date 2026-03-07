package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class InventoryFormPage {

    public static WebDriver driver;
    public static WebDriverWait wait;


    public InventoryFormPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Learn']")
    WebElement LearnDropDownButton;

    @FindBy(xpath = "//span[@class='item-icon' and contains(text(),'\uD83D\uDCA1')]")
    WebElement LearningMaterialButton;

    @FindBy(xpath = "//span[@class='tab-label' and contains(text(),'Web Automation Advance')]")
    WebElement WebAutomationButton;

    @FindBy(xpath = "//h3[@id='inventory-title']")
    WebElement InventoryFormTitle;

    @FindBy(xpath = "//select[@id='deviceType']")
    WebElement DeviceTypeDropDownButton;

    @FindBy(xpath = "//select[@id='brand']")
    WebElement BrandDropDownButton;

    @FindBy(id = "storage-128GB")
    WebElement Storage128GBRadioButton;

    @FindBy(id = "storage-64GB")
    WebElement Storage64GBRadioButton;

    @FindBy(id = "storage-256GB")
    WebElement Storage256GBRadioButton;

    @FindBy(id = "unit-price-value")
    WebElement UnitPriceValue; //This will be used for Validations

    @FindBy(id = "color")
    WebElement ColorDropDownButton;

    @FindBy(id = "quantity")
    WebElement QuantityInputField;

    @FindBy(id = "subtotal-value")
    WebElement SubTotalValue; //This will be used for Validations

    @FindBy(id = "address")
    WebElement AddressInputField;

    @FindBy(id = "inventory-next-btn")
    WebElement InventoryNextButton;


    @FindBy(id = "shipping-express")
    WebElement ExpressShippingRadioButton;
    @FindBy(id = "shipping-standard")
    WebElement StandardShippingRadioButton;

    @FindBy(id = "warranty-1yr")
    WebElement OneYearWarrantyRadioButton;
    @FindBy(id = "warranty-2yr")
    WebElement TwoYearWarrantyRadioButton;
    @FindBy(id = "warranty-none")
    WebElement NoWarrantyRadioButton;

    @FindBy(id = "discount-code")
    WebElement DiscountCodeInputField;

    @FindBy(id = "apply-discount-btn")
    WebElement ApplyDiscountButton;

    @FindBy(id = "breakdown-total-value")
    WebElement TotalValue; //This will be used for Validations

    @FindBy(id = "purchase-device-btn")
    WebElement ConfirmPurchaseButton;

    @FindBy(xpath = "//*[contains(text(),'Order Successful!')]")
    WebElement SuccessfulPurchaseAlertTitle; //This will be used for Validations

    @FindBy(xpath = "//button[@title='View Invoice History']")
    WebElement ViewInvoiceButton;

    @FindBy(id = "invoice-history-title")
    WebElement InvoiceHistoryTitle; //This will be used for Validations

    @FindBy(xpath = "//button[contains(text(),'View')]")
    WebElement ViewInvoice;

    public void clickLearnButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LearnDropDownButton));
        LearnDropDownButton.click();
    }

    public void clickLearnMaterialButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LearningMaterialButton));
        LearningMaterialButton.click();
    }

    public void clickWebAutomationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(WebAutomationButton));
        WebAutomationButton.click();
    }

    public void verifyInventoryForm() {
        wait.until(ExpectedConditions.visibilityOf(InventoryFormTitle));
        if (!InventoryFormTitle.isDisplayed()) {
            throw new RuntimeException("Inventory Form is not displayed.");
        }
    }

    public void selectDeviceType(String deviceType) {

        switch (deviceType.toLowerCase()) {
            case "phone", "laptop", "tablet" -> {
                wait.until(ExpectedConditions.elementToBeClickable(DeviceTypeDropDownButton));
                DeviceTypeDropDownButton.click();
                WebElement deviceOption = driver.findElement(By.xpath("//option[@value='" + deviceType.toLowerCase() + "']"));
                wait.until(ExpectedConditions.elementToBeClickable(deviceOption));
                deviceOption.click();
            }
            default ->
                    throw new IllegalArgumentException("Invalid device type: " + deviceType);// This will throw an exception if an invalid device type is provided.
        }
    }

    public void selectBrand(String brand) {

        switch (brand.toLowerCase()) {
            case "apple", "samsung", "xiaomi", "other" -> {
                wait.until(ExpectedConditions.elementToBeClickable(BrandDropDownButton));
                BrandDropDownButton.click();
                WebElement brandOption = driver.findElement(By.xpath("//option[@value='" + brand.toLowerCase() + "']"));
                wait.until(ExpectedConditions.elementToBeClickable(brandOption));
                brandOption.click();
            }
            default ->
                    throw new IllegalArgumentException("Invalid brand: " + brand);// This will throw an exception if an invalid brand is provided.
        }
    }

    public void chooseStorage(String storage) {

        String PhonePrice64GB = "R400.00";
        String PhonePrice128GB = "R480.00";
        String PhonePrice256GB = "R560.00";

        switch (storage.toUpperCase()) {
            case "64GB" -> {
                wait.until(ExpectedConditions.elementToBeClickable(Storage64GBRadioButton));
                Storage64GBRadioButton.click();
                Assert.assertEquals(UnitPriceValue.getText(), PhonePrice64GB, "Unit price for 64GB storage is incorrect.");
            }
            case "128GB" -> {
                wait.until(ExpectedConditions.elementToBeClickable(Storage128GBRadioButton));
                Storage128GBRadioButton.click();
                Assert.assertEquals(UnitPriceValue.getText(), PhonePrice128GB, "Unit price for 128GB storage is incorrect.");
            }
            case "256GB" -> {
                wait.until(ExpectedConditions.elementToBeClickable(Storage256GBRadioButton));
                Storage256GBRadioButton.click();
                Assert.assertEquals(UnitPriceValue.getText(), PhonePrice256GB, "Unit price for 256GB storage is incorrect.");
            }
            default ->
                    throw new IllegalArgumentException("Invalid storage option: " + storage);// This will throw an exception if an invalid storage option is provided.
        }
    }

    public void selectColor(String color) {

        switch (color.toLowerCase()) {
            case "black", "white", "blue", "gold" -> {
                wait.until(ExpectedConditions.elementToBeClickable(ColorDropDownButton));
                ColorDropDownButton.click();
                WebElement colorOption = driver.findElement(By.xpath("//option[@value='" + color.toLowerCase() + "']"));
                wait.until(ExpectedConditions.elementToBeClickable(colorOption));
                colorOption.click();
            }
            default ->
                    throw new IllegalArgumentException("Invalid color: " + color);// This will throw an exception if an invalid color is provided.
        }
    }

    public void enterQuantity(int quantity) {
        wait.until(ExpectedConditions.visibilityOf(QuantityInputField));
        QuantityInputField.clear();
        QuantityInputField.sendKeys(String.valueOf(quantity));// Enter the quantity as a string
        double unitPrice = Double.parseDouble(UnitPriceValue.getText().replace("R", ""));//
        double expectedSubTotal = unitPrice * quantity;//
        Assert.assertEquals(Double.parseDouble(SubTotalValue.getText().replace("R", "")), expectedSubTotal, "Subtotal calculation is incorrect.");//
    }

    public void enterAddress(String address) {
        wait.until(ExpectedConditions.visibilityOf(AddressInputField));
        AddressInputField.clear();
        AddressInputField.sendKeys(address);
    }

    public void clickInventoryNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(InventoryNextButton));
        InventoryNextButton.click();
    }

    //Extras Method and data sheetname to be created for these methods
    public void chooseShipping(String shippingOption) {

        double shippingCost = 25.00;
        String beforeShippingTotal = TotalValue.getText().replace("R", ""); // Get the total value before selecting shipping option

        switch (shippingOption.toLowerCase()) {
            case "express" -> {
                wait.until(ExpectedConditions.elementToBeClickable(ExpressShippingRadioButton));
                ExpressShippingRadioButton.click();
            }
            case "standard" -> {
                wait.until(ExpectedConditions.elementToBeClickable(StandardShippingRadioButton));
                StandardShippingRadioButton.click();
            }
            default ->
                    throw new IllegalArgumentException("Invalid shipping option: " + shippingOption);// This will throw an exception if an invalid shipping option is provided.
        }

        if (ExpressShippingRadioButton.isSelected()) {
            double totalValue = Double.parseDouble(beforeShippingTotal) + shippingCost;
            Assert.assertEquals(Double.parseDouble(TotalValue.getText().replace("R", "")), totalValue, "Total value calculation with express shipping is incorrect.");
        }
    }

    public void chooseWarranty(String warranty) {

        double oneYearWarrantyCost = 49.00;
        double twoYearWarrantyCost = 89.00;
        String beforeWarrantyTotal = TotalValue.getText().replace("R", "");

        switch (warranty.toLowerCase()) {
            case "1 year" -> {
                wait.until(ExpectedConditions.elementToBeClickable(OneYearWarrantyRadioButton));
                OneYearWarrantyRadioButton.click();
            }
            case "2 year" -> {
                wait.until(ExpectedConditions.elementToBeClickable(TwoYearWarrantyRadioButton));
                TwoYearWarrantyRadioButton.click();
            }
            case "none" -> {
                wait.until(ExpectedConditions.elementToBeClickable(NoWarrantyRadioButton));
                NoWarrantyRadioButton.click();
            }
            default -> throw new IllegalArgumentException("Invalid warranty option: " + warranty);// This will throw an
        }

        if (OneYearWarrantyRadioButton.isSelected()) {
            double totalValue = Double.parseDouble(beforeWarrantyTotal) + oneYearWarrantyCost;
            Assert.assertEquals(Double.parseDouble(TotalValue.getText().replace("R", "")), totalValue, "Total value calculation with 1 year warranty is incorrect.");
        } else if (warranty.equalsIgnoreCase("2 year")) {
            double totalValue = Double.parseDouble(beforeWarrantyTotal) + twoYearWarrantyCost;
            Assert.assertEquals(Double.parseDouble(TotalValue.getText().replace("R", "")), totalValue, "Total value calculation with 2 year warranty is incorrect.");
        }

    }

    public void enterDiscountCode(String discountCode) {
        wait.until(ExpectedConditions.visibilityOf(DiscountCodeInputField));
        DiscountCodeInputField.clear();
        DiscountCodeInputField.sendKeys(discountCode.toUpperCase());

        String totalValueBeforeDiscount = TotalValue.getText().replace("R", ""); // Get the total value before applying discount
        if (discountCode.equalsIgnoreCase("SAVE10")) {
            double expectedTotalValue = Double.parseDouble(totalValueBeforeDiscount) * 0.90; // Apply 10% discount
            ApplyDiscountButton.click();
            Assert.assertEquals(Double.parseDouble(TotalValue.getText().replace("R", "")), expectedTotalValue, "Total value calculation with DISCOUNT10 is incorrect.");
        } else if (discountCode.equalsIgnoreCase("SAVE20")) {
            double expectedTotalValue = Double.parseDouble(totalValueBeforeDiscount) * 0.80; // Apply 20% discount
            ApplyDiscountButton.click();
            Assert.assertEquals(Double.parseDouble(TotalValue.getText().replace("R", "")), expectedTotalValue, "Total value calculation with DISCOUNT20 is incorrect.");
        } else {
            throw new IllegalArgumentException("Invalid discount code: " + discountCode);// This will throw an exception if an invalid discount code is provided.
        }
    }

    public void clickConfirmPurchaseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ConfirmPurchaseButton));
        ConfirmPurchaseButton.click();
    }

    public void alertVerifySuccessfulPurchase(String purchasedAlertMessage) {
        wait.until(ExpectedConditions.visibilityOf(SuccessfulPurchaseAlertTitle));
        String alertTitle = SuccessfulPurchaseAlertTitle.getText();
        Assert.assertEquals(alertTitle.toLowerCase(), purchasedAlertMessage.toLowerCase(), "Successful purchase alert message is incorrect.");
    }

    public void clickViewInvoiceButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ViewInvoiceButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ViewInvoiceButton);
        ViewInvoiceButton.click();
    }

    public void verifyInvoiceHistoryPage() {
        wait.until(ExpectedConditions.visibilityOf(InvoiceHistoryTitle));
        Assert.assertTrue(InvoiceHistoryTitle.isDisplayed(), "Invoice History page title is not displayed.");
    }

    public void clickView() {
        wait.until(ExpectedConditions.elementToBeClickable(ViewInvoice));
        ViewInvoice.click();
    }


}
