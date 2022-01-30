package Tests;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCart extends BasePage {

        @BeforeMethod
        public void pagesetup(){
            driver.manage().window().maximize();
            driver.navigate().to("https://www.demoblaze.com/index.html");
        }


        @Test(priority = 10)
        public void addProductsToCart() throws InterruptedException {

            home.clickOn(home.getLaptops());
            Thread.sleep(5000);
            WebElement laptop = driver.findElement(By.linkText("Sony vaio i5"));
            laptop.click();
            Thread.sleep(5000);
            product.addToCart();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
            home.clickOn(home.getHome());
            Thread.sleep(5000);
            home.clickOn(home.getPhones());
            Thread.sleep(2000);
            WebElement phone = driver.findElement(By.linkText("Samsung galaxy s6"));
            phone.click();
            Thread.sleep(5000);
            product.addToCart();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
            home.clickOn(home.getHome());
            Thread.sleep(5000);
            home.clickOn(home.getMonitors());
            Thread.sleep(5000);
            WebElement monitor = driver.findElement(By.linkText("Apple monitor 24"));
            monitor.click();
            Thread.sleep(5000);
            product.addToCart();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
        }

        @Test(priority = 20)
        public void addedProductsAreDisplayedInCart() throws InterruptedException {
            addProductsToCart();

            home.clickOn(home.getCart());
            Thread.sleep(5000);

            String first = "Apple monitor 24";
            String actualFirst = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[2]")).getText();
            Assert.assertEquals(first, actualFirst);
            String second = "Samsung galaxy s6";
            String actualSecond = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[2]/td[2]")).getText();
            Assert.assertEquals(second, actualSecond);
            String thrid = "Sony vaio i5";
            String actualThird = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[3]/td[2]")).getText();
            Assert.assertEquals(thrid, actualThird);
        }

        @Test(priority = 30)
        public void totalPriceOfAddedProductsIsDisplayedInCart() throws InterruptedException {
            addProductsToCart();

            home.clickOn(home.getCart());
            Thread.sleep(5000);
            WebElement total = driver.findElement(By.className("panel-heading"));
            Assert.assertTrue(total.isDisplayed());
            String expectedTotal = "1550";
            Assert.assertEquals(total.getText(),expectedTotal);
        }

        @Test(priority = 40)
        public void deleteOptionIsAvailableForAddedProducts() throws InterruptedException {
            addProductsToCart();

            home.clickOn(home.getCart());
            Thread.sleep(5000);
            List<WebElement> deleteAll = driver.findElements(By.linkText("Delete"));
            int expectedNumProducts = 3;
            Assert.assertEquals(deleteAll.size(), expectedNumProducts);
        }

        @Test(priority = 50)
        public void productCanBeRemovedFromCart() throws InterruptedException {
            addProductsToCart();

            home.clickOn(home.getCart());
            Thread.sleep(5000);
            WebElement delete = driver.findElement(By.linkText("Delete"));
            List<WebElement> deleteAll = driver.findElements(By.linkText("Delete"));
            int beforeDelete = deleteAll.size();
            delete.click();
            Thread.sleep(2000);
            List<WebElement> deleteAll2 = driver.findElements(By.linkText("Delete"));
            int afterDelete = deleteAll2.size();
            Assert.assertNotEquals(beforeDelete,afterDelete);
        }

}
