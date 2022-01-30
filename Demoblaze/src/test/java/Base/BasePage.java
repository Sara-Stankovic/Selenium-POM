package Base;

import Pages.HomePage;
import Pages.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wdwait; // nije mi funkconisalo svuda kako treba, tako da je ostavljen Thread.sleep svuda
    public HomePage home;
    public ProductPage product;



    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        home = new HomePage(driver, wdwait);
        product = new ProductPage(driver, wdwait);
    }

    public void waitClick(WebElement we){
        wdwait.until(ExpectedConditions.elementToBeClickable(we));
    }


  /*  @AfterClass
    public void teardown(){
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }*/

}
