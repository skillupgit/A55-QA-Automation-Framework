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
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        loginToKoel();
        Thread.sleep(2000);
        //click on Avatar
        clickAvatarIcon();
        Thread.sleep(2000);
        //Generate random username
        String randomName = generateRandomName();
        System.out.println("Random name is: "+randomName);
        //provide current password
        provideCurrentPassword("te$t$tudent");
        Thread.sleep(2000);
        //Set the new profile name
        provideProfileName(randomName);
        Thread.sleep(2000);
        //Click on save
        clickSave();
        Thread.sleep(5000);
        //Assertion (Expected VS Actual results)
        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        System.out.println(actualProfileName.getText());
        Assert.assertEquals(actualProfileName.getText(),randomName);
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
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }


}
