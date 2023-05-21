package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@data-cookiebanner='accept_button']")
    public WebElement cookiesElement;

    @FindBy(xpath = "//*[@data-testid='open-registration-form-button']")
    public WebElement createElementi;

    @FindBy(id = "day")
    public WebElement dayElement;

    @FindBy(id = "month")
    public WebElement monthElement;

}
