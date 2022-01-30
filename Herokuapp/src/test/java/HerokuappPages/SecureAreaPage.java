package HerokuappPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecureAreaPage {

    public WebDriver driver;
    public WebElement logoutButton;
    public WebElement messageBox;

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.linkText("Logout"));
    }

    public WebElement getMessageBox() {
        return driver.findElement(By.id("flash"));
    }

    public String getMessageText(){
        return getMessageBox().getText();
    }

    public void clickLogoutButton(){
        getLogoutButton().click();
    }
}
