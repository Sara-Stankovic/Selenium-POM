package HerokuappPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;
    public WebElement usernameBox;
    public WebElement passwordBox;
    public WebElement loginButton;
    public WebElement messageBox;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameBox() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPasswordBox() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.className("radius"));
    }

    public WebElement getMessageBox() {
        return driver.findElement(By.id("flash"));
    }


    public void clickLoginButton(){
        getLoginButton().click();
    }


    public void insertUsername(String s){
        getUsernameBox().clear();
        getUsernameBox().sendKeys(s);

    }

    public void insertPassword(String s){
        getPasswordBox().clear();
        getPasswordBox().sendKeys(s);
    }

    public String getMessageText(){
        return getMessageBox().getText();
    }

}
