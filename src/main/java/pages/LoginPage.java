package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@class='a-input-text a-span12 auth-autofocus auth-required-field']")
    private WebElement emailField;

    @FindBy(xpath = "//span[@class='a-button-inner']//input[@id='continue']")
    private WebElement continueButtonOnLoginPage;

    @FindBy(xpath = "//input[@class='a-input-text a-span12 auth-autofocus auth-required-field']")
    private WebElement passwordField;

    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    private WebElement createAccountButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputEmail(String email){
        emailField.sendKeys(email);
        continueButtonOnLoginPage.click();
    }

    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }

    public String getTextFromInputField(){
        return passwordField.getText();
    }

    public void createAccount(){
        createAccountButton.click();
    }
}
