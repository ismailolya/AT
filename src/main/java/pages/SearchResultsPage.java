package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@data-component-type='s-search-result']//span[@class='a-size-medium a-color-base a-text-normal']")
    private List<WebElement> searchResultsProductsListText;

    @FindBy(xpath = "//img[@alt='Sponsored Ad - POLAR IGNITE - Advanced Waterproof Fitness Watch (Includes Polar Precision Heart Rate Integrated GPS and Sl...']")
    private WebElement firstProductInListButton;

    @FindBy(xpath = "//img[@alt='SAMSUNG Galaxy Buds+ Plus, True Wireless Earbuds (Wireless Charging Case Included), Black â€“ US Version']")
    private WebElement productSelectedFromMenu;

    @FindBy(xpath = "//li[@id='p_89/HP']//span[@class='a-size-base a-color-base']")
    private WebElement checkBoxForFilterByBrand;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchResultsList() {
        return searchResultsProductsListText;
    }

    public void clickOnFistProductInList() {
        firstProductInListButton.click();
    }

    public void clickOnProductSelectedFromMenu() {
        productSelectedFromMenu.click();
    }

    public void filterProductsByBrand() {
        checkBoxForFilterByBrand.click();
    }


}
