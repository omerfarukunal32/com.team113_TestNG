package tests.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class P02 {

    /*
- Birbirine bağımlı testler oluşturun.
- beforeClass oluşturup setUp ayarlarini yapin.
- Birbirine bağımlı testler oluşturarak
- ilk once wisequarte'a gidin
- sonra wisequarte'a bağımlı olarak youtube'a gidin
- daha sonra youtube'a bağımlı olarak amazon' a gidin
- driver'i kapatın.
*/
    static WebDriver driver;
    /*
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
     */
            //- Birbirine bağımlı testler oluşturarak
            //- ilk once wisequarte'a gidin
    @Test(priority = 1)
    public void wiseQuarter(){
        Driver.getDriver().get(ConfigReader.getProperty("wiseUrl"));
    }
    // - sonra wisequarte'a bağımlı olarak youtube'a gidin

    @Test (dependsOnMethods = "wiseQuarter")
    public void youTube(){
        Driver.getDriver().get(ConfigReader.getProperty("youTubeUrl"));
    }
    // - daha sonra youtube'a bağımlı olarak amazon' a gidin
    @Test(dependsOnMethods = "youTube")
    public void amazon(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //- driver'i kapatın.
        Driver.closeDriver();
    }

}
