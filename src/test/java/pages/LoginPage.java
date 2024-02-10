package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class is using the Selenium By abstract class to locate Elements.
 * Login helper methods are using the By class for locators.
 */
public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Web Elements

    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By loginBtn = By.cssSelector("button[type='submit']");

    //Helper Methods
/*
    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password){
        findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit(){
        findElement(loginBtn).click();
    }*/

   public void login(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }


}
