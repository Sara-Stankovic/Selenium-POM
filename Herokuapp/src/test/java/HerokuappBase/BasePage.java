package HerokuappBase;

import HerokuappPages.LoginPage;
import HerokuappPages.SecureAreaPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BasePage {

   public WebDriver driver;
   public WebDriverWait wdwait;
   public LoginPage loginPage;
   public SecureAreaPage secureAreaPage;
   public ExcelReader excelReader;
   public String HomeURL;


    @BeforeClass
    public void setup() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        secureAreaPage = new SecureAreaPage(driver);
        excelReader = new ExcelReader("C:\\Users\\Sara\\IdeaProjects\\Herokuapp\\TestBook.xlsx");
        HomeURL = excelReader.getStringData("URL", 1, 0);
    }


    public void waiter(WebElement w){
        wdwait.until(ExpectedConditions.visibilityOf(w));
    }

    @AfterClass
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }

}
