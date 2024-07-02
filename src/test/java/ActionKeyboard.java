import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionKeyboard {

    WebDriver driver;

    @BeforeMethod
    public void browserOpen(){
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @Test
    public void keyBoardAction1() throws InterruptedException {
        driver.get("https://www.google.com");
        WebElement search = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        search.sendKeys("test keys");

        Actions actions = new Actions(driver);
        //select text (ctrl + A)
        //Action storingBuildOperation = actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build();
        //storingBuildOperation.perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        Thread.sleep(5000);

        actions.keyDown(Keys.SHIFT).sendKeys("this is in capital").keyUp(Keys.SHIFT).perform();

        Thread.sleep(5000);

        actions.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("x").keyUp(Keys.CONTROL).perform();
    }

    @Test
    public void keyBoardAction2() throws InterruptedException {
        driver.get("https://leafground.com/list.xhtml");
        Thread.sleep(4000);

        List<WebElement> selectables = driver.findElements(By.xpath("//*[@id=\"pickList\"]/div[2]/ul/li"));
        int size = selectables.size();
        System.out.println("List count is: "+ size);

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(selectables.get(0)).click(selectables.get(2)).keyUp(Keys.CONTROL).perform();
    }
}
