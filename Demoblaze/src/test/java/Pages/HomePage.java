package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    public WebDriver driver;
    public WebElement phones;
    public WebElement laptops;
    public WebElement monitors;
    public WebElement cart;
    public WebElement home;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPhones() {
        return driver.findElement(By.linkText("Phones"));
    }

    public WebElement getLaptops() {
        return driver.findElement(By.linkText("Laptops"));
    }

    public WebElement getMonitors() {
        return driver.findElement(By.linkText("Monitors"));
    }

    public WebElement getCart() {
        return driver.findElement(By.linkText("Cart"));
    }

    public WebElement getHome() {
        return driver.findElement(By.cssSelector(".nav-item.active"));
    }

    //metoda za klik na element
    public void clickOn(WebElement we){
        we.click();
    }

    //metoda koja ispisuje sve proizvode sa sajta
    public void report(String kategorija) throws InterruptedException {

        System.out.println(kategorija + ":");
        List<WebElement> products = driver.findElements(By.className("card-block"));
        List<WebElement> name = driver.findElements(By.className("hrefch"));
        List<WebElement> description = driver.findElements(By.id("article"));
        List<WebElement> price = driver.findElements(By.tagName("h5"));
        Thread.sleep(5000);
        int suma = 0;
        for(int i = 0; i < products.size(); i++){
            System.out.println(i+1 + ".");
            System.out.println(" naziv: " + name.get(i).getText());
            System.out.println(" opis: " + description.get(i).getText());
            System.out.println(" cena: " + price.get(i+4).getAttribute("innerHTML"));
            String cena = price.get(i+4).getAttribute("innerHTML").replace("$", "");
            int c = Integer.parseInt(cena);
            suma += c;
        }
        System.out.println("Ukupno proizvoda iz kategorije " + kategorija + ": " + products.size());
        System.out.println("Ukupna cena iz kategorije " + kategorija + ": " + suma + "\n");

    }

}
