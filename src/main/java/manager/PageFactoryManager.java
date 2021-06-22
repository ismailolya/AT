package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SearchResultsPage getSearchResultsPage(){
        return new SearchResultsPage(driver);
    }

    public ProductPage getProductPage(){
        return new ProductPage(driver);
    }

    public CartPage getCartPage(){
        return new CartPage(driver);
    }

    public LoginPage getLoginPage(){
        return new LoginPage(driver);
    }

    public RegisterPage getRegisterPage(){
        return new RegisterPage(driver);
    }

    public FilterResultsPage getFilterResultsPage(){
        return new FilterResultsPage(driver);
    }

    public CustomerServicePage getCustomerServicePage(){
        return new CustomerServicePage(driver);
    }
}
