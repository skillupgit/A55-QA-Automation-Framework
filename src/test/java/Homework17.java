import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedSuccessMessage = "Added 1 song into \"TestPro Playlist.\"";
        //Navigate to Koel App
        navigateToPage();
        //Login
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        loginToKoel();
        Thread.sleep(2000);
        //search song
        searchSong("Dark");
        Thread.sleep(2000);
        //click view all button
        clickViewAllBtn();
        Thread.sleep(2000);
        //Select first Song
        selectFirstSongResult();
        Thread.sleep(2000);
        //click add to button to add the song
        clikAddToBtn();
        Thread.sleep(2000);
        //choose playlist
        choosePlaylist();
        Thread.sleep(2000);
        //Assertions
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedSuccessMessage);
    }

    public String getAddToPlaylistSuccessMsg(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    public void choosePlaylist() {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'TestPro Playlist')]"));
        playlist.click();
    }

    public void clikAddToBtn() {
        WebElement addToBtn = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToBtn.click();
    }

    public void selectFirstSongResult() {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
    }

    public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    //Helper Methods
    public void searchSong(String songName) {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(songName);
    }

}
