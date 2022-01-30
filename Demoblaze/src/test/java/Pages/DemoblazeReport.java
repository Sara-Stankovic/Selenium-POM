package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

//report svih proizvoda po kategorijama
public class DemoblazeReport {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        HomePage home = new HomePage(driver, wdwait);
        driver.manage().window().maximize();

        driver.navigate().to("https://www.demoblaze.com/index.html");
        home.clickOn(home.getPhones());
        Thread.sleep(5000);
        home.report("Phones");
        Thread.sleep(5000);
        home.clickOn(home.getLaptops());
        Thread.sleep(5000);
        home.report("Laptops");
        Thread.sleep(5000);
        home.clickOn(home.getMonitors());
        Thread.sleep(5000);
        home.report("Monitors");
        }

        }















