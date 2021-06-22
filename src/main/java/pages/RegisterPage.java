package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

    @FindBy(xpath = "//input[@id='ap_customer_name']")
    private WebElement inputNameField;

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement inputEmailField;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement inputPasswordField;

    @FindBy(xpath = "//input[@id='ap_password_check']")
    private WebElement inputPasswordAgainField;

    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='a-box a-alert a-alert-warning a-spacing-base']")
    private WebElement warningBox;

    @FindBy(xpath = "//div[@class='a-box a-alert a-alert-warning a-spacing-base']//h4[@class='a-alert-heading']")
    private WebElement informationOnWarningBox;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void inputDataForRegistration(String name, String email, String password){
        inputNameField.sendKeys(name);
        inputEmailField.sendKeys(email);
        inputPasswordField.sendKeys(password);
        inputPasswordAgainField.sendKeys(password);
    }

    public void submitRegisterInformation(){
        continueButton.click();
    }

    public void isSystemWarningMassageDisplayed(){
        warningBox.isDisplayed();
    }

    public String systemWarningMassage(){
        return informationOnWarningBox.getText();
    }
}
