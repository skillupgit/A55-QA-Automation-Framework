import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class AllSongsTest extends BaseTest{


    //PlaySOng Test usiong Procedural Programming
    @Test
    public void playSongWithContextClick() throws InterruptedException {
        //Login
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        loginToKoel();
        //Thread.sleep(2000);
        //chooseAllSongsList();
        chooseAllSongsList();
        //Thread.sleep(2000);
        //contextClickFirstSong();
        contextClickFirstSong();
        //Thread.sleep(2000);
        //choosePlay();
        choosePlay();
        //Thread.sleep(2000);
        //Assertions
        Assert.assertTrue(isSongPlaying());
    }

    //PlaySOng Test using OOP and Page Factory
    @Test
    public void playSong() throws InterruptedException {
        //Login
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        //loginPage.login();
        //loginPage.loginToKoelApp();

        loginPage.provideEmail("demo@class.com")
                .providePassword("te$t$tudent")
                .clickSubmit();

        homePage.chooseAllSongsList();
        allSongsPage.contextClickFirstSong();
        allSongsPage.choosePlay();
        //Assertions
        Assert.assertTrue(allSongsPage.isSongPlaying());
    }

    public boolean isSongPlaying(){
        WebElement soundBarVisualizer = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[data-testid= 'sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }

    public void choosePlay() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
    }

    public void contextClickFirstSong() {
        WebElement firstSongElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongElement).perform();
    }



}
