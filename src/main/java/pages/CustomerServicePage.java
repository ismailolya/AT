package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CustomerServicePage extends BasePage {

    @FindBy(xpath = "//div[@class='ewc-compact sc-java-remote-feature celwidget']")
    private WebElement contentCartWindowOnInnerPage;

    @FindBy(xpath = "//div[@class='a-box self-service-rich-card']")
    private List<WebElement> boxesOnCustomerServicePage;

    @FindBy(xpath = "//div[@class='a-search a-span12']")
    private WebElement inputFieldOnCustomerServicePage;

    @FindBy(xpath = "//div[@class='a-search a-span12']//input[@id='helpsearch']")
    private WebElement areaForInputInInputField;

    public CustomerServicePage(WebDriver driver) {
        super(driver);
    }

    public boolean isContentCartVisibilityOnInnerPage() {
        return contentCartWindowOnInnerPage.isDisplayed();
    }

    public int getAmountOfBoxesOnCustomerServicePage() {
        return boxesOnCustomerServicePage.size();
    }

    public boolean isInputFieldOnCustomerServicePageDisplayed() {
        return inputFieldOnCustomerServicePage.isDisplayed();
    }

    public void inputTextInInputField(String checkWord) {
        areaForInputInInputField.sendKeys(checkWord);
    }

}
