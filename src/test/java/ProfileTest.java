import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest{

    @Test
    public void changeProfileName() throws InterruptedException {
        //navigate to Koel
        navigateToPage();
        //login with correct credential
        provideEmail("demo@koel.dev");
        providePassword("demo");
        loginToKoel();
        Thread.sleep(2000);
        //click on Avatar
        clickAvatarIcon();
        Thread.sleep(2000);
        //Generate random username
        String randomName = generateRandomName();
        System.out.println("Random name is: "+randomName);
        //provide current password
        provideCurrentPassword("demo");
        Thread.sleep(2000);
        //Set the new profile name
        provideProfileName(randomName);
        Thread.sleep(2000);
        //Click on save
        clickSave();
        Thread.sleep(5000);
        //Assertion (Expected VS Actual results)
        WebElement updateNotification = driver.findElement(By.xpath("//div[@class='message success']//main['Profile updated']"));

        System.out.println(updateNotification.getText());
        Assert.assertTrue(updateNotification.isDisplayed());
    }

    public void clickSave() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    public void provideProfileName(String newName) {
        WebElement profileNameField = driver.findElement(By.cssSelector("[name='name']"));
        profileNameField.clear();
        profileNameField.sendKeys(newName);
    }

    public void provideCurrentPassword(String currentPassword) {
        WebElement currentPasswordField = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPasswordField.clear();
        currentPasswordField.sendKeys(currentPassword);
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("a.view-profile"));
        avatarIcon.click();
    }


}
