package HerokuappTests;

import HerokuappBase.BasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BasePage {

    @BeforeMethod
    public void setupPage(){
        driver.manage().window().maximize();
        driver.navigate().to(HomeURL);
    }

    public void login(){
        String validUsername = excelReader.getStringData("Login",1, 0);
        String validPassword = excelReader.getStringData("Login", 1,1);

        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickLoginButton();
    }

    @Test(priority = 10)
    public void userCanLoginWithValidCredentials(){

        login();
        waiter(secureAreaPage.getLogoutButton());

        String expectedURL = excelReader.getStringData("Login", 1, 2);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

        Assert.assertTrue(secureAreaPage.getLogoutButton().isDisplayed());

        Assert.assertTrue(secureAreaPage.getMessageBox().isDisplayed());

        String expectedMessage = excelReader.getStringData("Login", 1, 3);
        String actualMessage = secureAreaPage.getMessageText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    @Test(priority = 20)
    public void userCannotLoginWithoutUsername(){

        waiter(loginPage.getLoginButton());
        String validPassword = excelReader.getStringData("Login", 1,1);
        loginPage.getUsernameBox().clear();

        loginPage.insertPassword(validPassword);
        loginPage.clickLoginButton();
        waiter(loginPage.getMessageBox());

        Assert.assertTrue(loginPage.getMessageBox().isDisplayed());

        String expectedMessage = excelReader.getStringData("Login", 1, 4);
        String actualMessage = loginPage.getMessageText();

        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test(priority = 30)
    public void userCanLogout(){
        login();
        waiter(secureAreaPage.getLogoutButton());

        secureAreaPage.clickLogoutButton();
        waiter(loginPage.getLoginButton());

        String expectedURL = excelReader.getStringData("Logout", 1, 0);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
    }

    @Test(priority = 40)
    public void userCannotLoginWithInvalidCredentials(){
        for(int i = 1; i <= 5; i++) {
            String invalidusername = excelReader.getStringData("Credentials", i, 0);
            String invalidpass = excelReader.getStringData("Credentials", i, 1);
            loginPage.insertUsername(invalidusername);
            loginPage.insertPassword(invalidpass);
            waiter(loginPage.getLoginButton());
            loginPage.clickLoginButton();
            Assert.assertTrue(loginPage.getMessageBox().isDisplayed());
        }
    }

}
