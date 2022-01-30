package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public WebElement addToCartButton;


    public ProductPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getAddToCartButton() {
        return driver.findElement(By.linkText("Add to cart"));
    }

    //metoda za dodavanje proizvoda u korpu
    public void addToCart(){
        getAddToCartButton().click();
    }

}
