package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    public WebDriver driver;
    public WebElement addToCartButton;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddToCartButton() {
        return driver.findElement(By.linkText("Add to cart"));
    }

    //metoda za dodavanje proizvoda u korpu
    public void addToCart(){
        getAddToCartButton().click();
    }

}
