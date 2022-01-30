package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//report svih proizvoda po kategorijama
public class DemoblazeReport {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        HomePage home = new HomePage(driver);
        driver.manage().window().maximize();

        driver.navigate().to("https://www.demoblaze.com/index.html");
        home.clickOn(home.getPhones());
        Thread.sleep(2000);
        home.report("Phones");
        Thread.sleep(2000);
        home.clickOn(home.getLaptops());
        Thread.sleep(2000);
        home.report("Laptops");
        Thread.sleep(2000);
        home.clickOn(home.getMonitors());
        Thread.sleep(2000);
        home.report("Monitors");
        }

        }















