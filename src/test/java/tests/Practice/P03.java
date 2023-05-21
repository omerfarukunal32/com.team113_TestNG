package tests.Practice;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.Saucedemo;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class P03 {
    @Test
    public void test01(){
        // Navigate to https://www.saucedemo.com/
        Driver.getDriver().get(ConfigReader.getProperty("saucedemoUrl"));
        // Enter the username as standard_user
        // Enter the password as secret_sauce
        Saucedemo saucedemo = new Saucedemo();
        saucedemo.userName.sendKeys("standard_user");
        saucedemo.password.sendKeys("secret_sauce");

        // Click on login button
        saucedemo.loginButtonElement.click();
        // Test 1: Choose price low to high
        Actions actions = new Actions(Driver.getDriver());

        actions.click(saucedemo.nameAtoZ).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();


        // Test 2:Verify item prices are sorted from Iow to high with soft Assert
        System.out.println(saucedemo.sonucElementleri.getText());
        List<WebElement> sonucElementList= Driver.getDriver().findElements(By.xpath("//*[@class='inventory_item_price']"));
        for (WebElement eachWebElement: sonucElementList
             ) {
            System.out.println(eachWebElement.getText());
        }
        System.out.println(saucedemo.sonucElementleri.getSize());


    }


}
