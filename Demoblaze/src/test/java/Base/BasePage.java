package Base;

import Pages.HomePage;
import Pages.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BasePage {

    public WebDriver driver;
    public HomePage home;
    public ProductPage product;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        home = new HomePage(driver);
        product = new ProductPage(driver);
    }


    @AfterClass
    public void teardown(){
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }

}
