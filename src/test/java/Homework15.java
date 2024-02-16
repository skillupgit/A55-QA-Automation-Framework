import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework15 extends BaseTest{

    @Test
    public void logoutTest() throws InterruptedException {
        //Pre-Condition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        //Declaration
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Steps 1: Open Browser and navigate to Koel app.
        String url = "https://demo.koel.dev/";
        driver.get(url);
        //Step 2: Login
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("demo@koel.dev");
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("demo");
        WebElement loginBtn =  driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        Thread.sleep(2000);
        //Step 3: Logout
        WebElement logoutBtn = driver.findElement(By.xpath("//button[@data-title='Log out']"));
        logoutBtn.click();
        Thread.sleep(2000);
        WebElement loginForm = driver.findElement(By.xpath("//form[@data-testid='login-form']"));
        //Assertion
        Assert.assertTrue(loginForm.isDisplayed());
        driver.quit();
    }

}
