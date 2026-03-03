package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryFormPage {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public InventoryFormPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()=\"Learn\"]")
    WebElement LearnDropDownButton;

    @FindBy(xpath = "//button[@class = 'nav-dropdown-item active']")
    WebElement LearningMaterialButton;

    @FindBy(id = "tab-btn-web")
    WebElement WebAutomationButton;

    @FindBy(id = "deviceType")
    WebElement DeviceTypeDropDownButton;

    @FindBy(id = "brand")
    WebElement BrandDropDownButton;

    @FindBy(id = "storage-128GB")
    WebElement Storage128GBRadioButton;

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

    @FindBy(id = "warranty-1yr")
    WebElement OneYearWarrantyRadioButton;

    @FindBy(id = "discount-code")
    WebElement DiscountCodeInputField;

    @FindBy(id = "purchase-device-btn")
    WebElement ConfirmPurchaseButton;

    @FindBy(xpath = "//p[@style = 'font-weight: 700; font-size: 0.85rem; color: rgb(14, 116, 144); margin-bottom: 6px;']")
    WebElement SuccessfulPurchaseAlertMessage; //This will be used for Validations

    @FindBy(id = "view-history-btn")
    WebElement ViewInvoiceButton;

    @FindBy(id = "invoice-history-title")
    WebElement InvoiceHistoryTitle; //This will be used for Validations

    @FindBy(linkText = "\uD83D\uDC41\uFE0F View")
    WebElement ViewInvoice;




}
