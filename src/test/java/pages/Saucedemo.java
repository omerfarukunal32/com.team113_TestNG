package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Saucedemo {
    public Saucedemo(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id="user-name")
    public WebElement userName;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id="login-button")
    public WebElement loginButtonElement;

    @FindBy(className = "product_sort_container")
    public WebElement nameAtoZ;

    @FindBy(xpath = "(//*[text()='Price (low to high)'])[2]")
    public WebElement lowToHigh;

    @FindBy(xpath = "//*[@class='inventory_item_price']")
    public WebElement sonucElementleri;



}
