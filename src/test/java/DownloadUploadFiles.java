import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DownloadUploadFiles {

    WebDriver driver;

    @BeforeMethod
    public void openFileTestPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.leafground.com/file.xhtml");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    //Basic download
    @Test
    public void basicDownload() throws InterruptedException {
        WebElement downloadBtn = driver.findElement(By.id("j_idt93:j_idt95"));
        downloadBtn.click();
        Thread.sleep(3000);

        //validation: java
        File file = new File("C:\\Users\\Samitha\\Downloads");
        File[] totalFiles = file.listFiles();

        for(File findFile:totalFiles){
            if(findFile.getName().equals("TestLeaf Logo.png")){
                System.out.println("File is downloaded");
                break;
            }
        }
    }

    //upload : clipboard functionality
    @Test
    public void uploadFile() throws AWTException, InterruptedException {
        WebElement chooseBtn = driver.findElement(By.id("j_idt88:j_idt89"));
        chooseBtn.click();

        StringSelection selection = new StringSelection("C:\\Users\\Samitha\\Pictures\\facebook.jpg");

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    //second way to file upload using sendkeys (if input type is file)
    @Test
    public void uploadFile2(){
        WebElement chooseFile = driver.findElement(By.id("j_idt88:j_idt89_input"));
        chooseFile.sendKeys("C:\\Users\\Samitha\\Pictures\\facebook.jpg");
    }

}
