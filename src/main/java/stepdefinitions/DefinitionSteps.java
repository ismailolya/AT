package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"ALL", "MoveFieldAssignmentToInitializer"})
public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    private static final String NAME_BRAND_FOR_FILTER= "HP";
    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    CartPage cartPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    FilterResultsPage filterResultsPage;
    CustomerServicePage customerServicePage;

    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks search field visibility")
    public void checkSearchVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @When("User makes search by keyword {string}")
    public void writeKeywordInSearchField(final String keyword) {
        homePage.searchByKeyword(keyword);
    }

    @And("User clicks search button")
    public void pressSearchButtonOnHomePage(){
        homePage.pressSearchButton();
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
    }

    @Then("User checks that search results contain keyword {string}")
    public void checkSearchResults(final String keyword2) {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        for (WebElement webElement : searchResultsPage.getSearchResultsList()) {
            assertTrue(webElement.getText().contains(keyword2));
        }
    }

    @And("User chooses product from search result list")
    public void chooseFirstProductInSearchResultList(){
        searchResultsPage.clickOnFistProductInList();
    }

    @And("User clicks add to cart button")
    public void addProductToCart(){
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.addProductToCart();
    }

    @Then("User checks that amount of products in cart are {string}")
    public void checkIfProductAdedToCart(String amount){
        assertEquals(productPage.getAmountOfProductInCart(), amount);
    }

    @And("User go to cart page")
    public void openCartPage(){
        productPage.goToCartPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        cartPage = pageFactoryManager.getCartPage();
    }

    @And("User increases qty of product on {string}")
    public void increaseQauntityOfProductInCart(String qty){
        cartPage.increaseQuantityOfProductInCart(qty);
    }

    @Then("System displays a massage with available qty of product")
    public void isSystemMassageDisplaydOnCartPage(){
        cartPage.isSystemMassageDisplayed();
    }

    @Then("User delete product from cart")
    public void deleteProductFromCart(){
        cartPage.deleteProductFromCart();
        assertEquals(productPage.getAmountOfProductInCart(), "0");
    }

    //Login and create account

    @And("User checks button Account&List visibility")
    public void checkAccountAndListsVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isAccountAndListsButtonVisible();
    }

    @And("User clicks on button Account&List")
    public void clickAccountAndListsButton(){
        homePage.clickOnAccountAndListsButtonOnHomePage();
        loginPage = pageFactoryManager.getLoginPage();
    }

    @And("User inputs {string} and continue")
    public void inputEmailForLogin(String email){
        loginPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        loginPage.inputEmail(email);
    }

    @Then("System enables to inputs {string} for sign-in")
    public void inputPasswordForLogin(String password){
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        loginPage.inputPassword(password);
        assertEquals(loginPage.getTextFromInputField(), "password");
    }

    @And("User clicks on create account button")
    public void clickToCreateAccount(){
        loginPage.createAccount();
    }

    @And("User inputs {string}, existing {string}, {string} to create account")
    public void inputUserDataToCreateAccount(String name, String email, String password){
        registerPage = pageFactoryManager.getRegisterPage();
        registerPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        registerPage.inputDataForRegistration(name, email, password);
    }

    @And("User continue registration")
    public void continueRegistration(){
        registerPage.submitRegisterInformation();
    }

    @Then("System displays massage that email already existed")
    public void isSystemMassagOnRegisterPageDisplayed(){
        registerPage.isSystemWarningMassageDisplayed();
        assertEquals(registerPage.systemWarningMassage(), "Email address already in use");
    }

    @And("User clicks menu button")
    public void clickOnMenuButton(){
        homePage.clickOnMenuButton();
    }

    @And("User chooses category of product")
    public void chooseCategoryOfProductFromMenu(){
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMenuWindowVisible());
        homePage.clickOnCategoryOnMenu();
    }

    @And("User chooses subcategory of product")
    public void chooseSubcategoryOfProductFromCategoryList(){
        homePage.clickOnSubcategoryOnMenu();
    }

    @And("User chooses product from result page")
    public void chooseProductFromResultPage(){
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickOnProductSelectedFromMenu();
    }

    @And("User makes filter by brand")
    public void getFilterProductByBrand(){
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.filterProductsByBrand();
    }

    @Then("User checks that after filtering products contains name of chosen brand")
    public void checkFilterResultsContainChosenBrand(){
        filterResultsPage = pageFactoryManager.getFilterResultsPage();
        filterResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        for (WebElement webElement : filterResultsPage.getFilterResultsList()) {
            assertTrue(webElement.getText().contains(NAME_BRAND_FOR_FILTER));
        }
    }

    @And("User goes to inner page")
    public void chooseCustomerServicePage(){
        productPage.clickOnCustomerServiceButton();
    }

    @Then("User can see on inner page content of the cart")
    public void isContentCartVisibilityOnInnerPage(){
        customerServicePage = pageFactoryManager.getCustomerServicePage();
        customerServicePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(customerServicePage.isContentCartVisibilityOnInnerPage());
    }

    @And("User clicks on customer service button")
    public void clickOnCustomerServiceButton(){
        homePage.clickOnCustomerServiceButton();
    }

    @And("User checks that customer service page contains {string}")
    public void checkCountOfBoxesOnCustomerServicePage(String numberOfBoxes){
        customerServicePage = pageFactoryManager.getCustomerServicePage();
        customerServicePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(customerServicePage.getAmountOfBoxesOnCustomerServicePage(), Integer.parseInt(numberOfBoxes));
    }

    @And("User checks that customer service page contains field for input")
    public void isInputFieldOnCustomerServicePageDisplayed(){
        assertTrue(customerServicePage.isInputFieldOnCustomerServicePageDisplayed());
    }

    @Then("User input {string} in input field")
    public void enableToInputWordInInputField(String checkWord){
        customerServicePage.inputTextInInputField(checkWord);
    }

}
