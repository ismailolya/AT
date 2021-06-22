package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[@class='nav-search-field ']//input[@id='twotabsearchtextbox']")
    private WebElement searchField;

    @FindBy(xpath = "//span[@class='nav-search-submit-text nav-sprite nav-progressive-attribute']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@data-csa-c-slot-id='nav-link-accountList']")
    private WebElement accountAndListsButton;

    @FindBy(xpath = "//a[@data-csa-c-slot-id='HamburgerMenuDesktop']")
    private WebElement menuButton;

    @FindBy(xpath = "//a[@data-ref-tag='nav_em_1_1_1_6']")
    private WebElement categoryButtonOnMenu;

    @FindBy(xpath = "//a[@href='/s?bbn=16225009011&rh=i%3Aspecialty-aps%2Cn%3A%2116225009011%2Cn%3A281407&ref_=nav_em__nav_desktop_sa_intl_accessories_and_supplies_0_2_5_2']")
    private WebElement subcategoryButtonOnMenu;

    @FindBy(xpath = "//div[@class='nav-ignore-pinning hmenu-translateX']")
    private WebElement menuWindowOnHomePage;

    @FindBy(xpath = "//a[@data-csa-c-content-id='nav_cs_customerservice_2bf4fe8c5ec54e6bae2d1c24043f012b']")
    private WebElement customerServiceButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void isSearchFieldVisible(){
        searchField.isDisplayed();
    }

    public void clickOnAccountAndListsButtonOnHomePage(){
        accountAndListsButton.click();
    }

    public void searchByKeyword(String keyword){
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public void pressSearchButton(){
        searchButton.click();
    }

    public void isAccountAndListsButtonVisible(){
        accountAndListsButton.isDisplayed();
    }

    public void clickOnMenuButton(){
        menuButton.click();
    }

    public void clickOnCategoryOnMenu(){
        categoryButtonOnMenu.click();
    }

    public void clickOnSubcategoryOnMenu(){
        subcategoryButtonOnMenu.click();
    }

    public WebElement getMenuWindowVisible(){
        return menuWindowOnHomePage;
    }

    public void clickOnCustomerServiceButton() {
        customerServiceButton.click();
    }

}
