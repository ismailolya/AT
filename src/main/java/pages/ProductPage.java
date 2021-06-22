package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement cartButtonOnProductPage;

    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement amountOfProductInCart;

    @FindBy(xpath = "//div[@id='nav-cart-count-container']")
    private WebElement cartButtonOnHeader;

    @FindBy(xpath = "//a[@data-csa-c-content-id='nav_cs_customerservice_2bf4fe8c5ec54e6bae2d1c24043f012b']")
    private WebElement customerServiceButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart() {
        cartButtonOnProductPage.click();
    }

    public String getAmountOfProductInCart() {
        return amountOfProductInCart.getText();
    }

    public void goToCartPage() {
        cartButtonOnHeader.click();
    }

    public void clickOnCustomerServiceButton() {
        customerServiceButton.click();
    }

}
