package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//span[@data-a-class='quantity']")
    private WebElement quantityButtonInCart;

    @FindBy(xpath = "//a[@id='dropdown1_10']")
    private WebElement maxNumberInQuantityList;

    @FindBy(xpath = "//input[@class='a-input-text a-width-small sc-quantity-textfield sc-update-quantity-input sc-hidden']")
    private WebElement quantityFieldOfProductInCart;

    @FindBy(xpath = "//span[@class='a-button a-button-primary a-button-small sc-update-link']")
    private WebElement updateQuantityOfProductInCart;
    private String qty;

    @FindBy(xpath = "//div[@class='a-box a-alert a-alert-warning sc-inline-qty-update-msg a-spacing-top-mini']")
    private WebElement systemWindowInCart;

    @FindBy(xpath = "//input[@name='submit.delete.C1fcd4d65-cc02-4887-997e-108937cbb1f5']")
    private WebElement deleteButtonInCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void increaseQuantityOfProductInCart(String qty){
        this.qty = qty;
        quantityButtonInCart.click();
        maxNumberInQuantityList.click();
        quantityFieldOfProductInCart.clear();
        quantityFieldOfProductInCart.sendKeys(qty);
        updateQuantityOfProductInCart.click();
    }

    public boolean isSystemMassageDisplayed(){
        return systemWindowInCart.isDisplayed();
    }

    public void deleteProductFromCart(){
        deleteButtonInCart.click();
    }

}
