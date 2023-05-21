package tests.GruppeTeam1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class Odev1 {
    @Test
    public void amazonTest(){

        //TC 1: Amazon link count:
        //2. Go to “https://www.amazon.com/”
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage = new AmazonPage();

        //3. Get all links
        List<WebElement> allLinksList = Driver.getDriver().findElements(By.tagName("a"));
        System.out.println(allLinksList.size());
        // burayi TestNG ile yapamadim

        //4. Get number of links that has text
        List<WebElement> linkWithText = Driver.getDriver().findElements(By.xpath("//a[@class='nav_a']"));
        System.out.println(linkWithText.size());

        //5. Print to console only the links that has text
        for (WebElement eachLink : linkWithText
             ) {
            System.out.println(eachLink.getText());
        }
    }

    @Test
    public void facebookTest(){
        String ilkHandle = Driver.getDriver().getWindowHandle();
        //TC 1: Facebook dropdown verification

        //1. Open chrome browser

        //2. Go to “https://www.facebook.xn--com-9o0a
        Driver.getDriver().get(ConfigReader.getProperty("faceUrl"));
        FacebookPage facebookPage = new FacebookPage();
        facebookPage.cookiesElement.click();
        //3. Verify:
        //● day dd has 31 day options
        facebookPage.createElementi.click();
        Select select = new Select(facebookPage.dayElement);

        int expectedDaySize= 31;
        int actualDaySize = select.getOptions().size();
        Assert.assertTrue(expectedDaySize==actualDaySize);

        //● month dd has 12 month options
        select=new Select(facebookPage.monthElement);
        int expectedMonthSize =12;
        int actualMonthSize = select.getOptions().size();
        Assert.assertTrue(expectedMonthSize==actualMonthSize);

        //● year dd has 115 year options

        //4. Select your date of birth

        //5. Quit browser


    }



}
