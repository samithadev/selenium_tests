import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class ButtonExample {

    WebDriver driver;

    @BeforeMethod
    public void openTestBrowser(){
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(800,600);
        driver.manage().window().setSize(newSize);
//        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void testButtons(){
        //01. Click and Confirm title.
        WebElement clickButton = driver.findElement(By.id("j_idt88:j_idt90"));
        clickButton.click();
        String expectTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if(actualTitle.contains("Dashboard")){
            System.out.println("confirm title");
        }else{
            System.out.println("title is different");
        }
//        Assert.assertEquals(actualTitle, expectTitle,"Title is different");
        driver.navigate().back();

        //02. Confirm if the button is disabled.
        WebElement disableButton = driver.findElement(By.id("j_idt88:j_idt92"));
        boolean isEnabled = disableButton.isEnabled();
        System.out.println("Button is enabled: "+ isEnabled);

        //03. Find the position of the Submit button
        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPosition = getPosition.getLocation();
        int x = xyPosition.getX();
        int y = xyPosition.getY();
        System.out.println("Position X is: "+ x+ " Position Y is: "+ y);

        //04. Find the Save button color
        WebElement saveButton = driver.findElement(By.id("j_idt88:j_idt96"));
        String buttonColor = saveButton.getCssValue("background-color");
        System.out.println("Button color: "+ buttonColor);

        //05. Find the height and width of this button
        WebElement button = driver.findElement(By.id("j_idt88:j_idt98"));
        double height = button.getSize().getHeight();
        double width = button.getSize().getWidth();
        System.out.println("Height: "+ height+ " Width: "+ width);

        //06. Mouse over and confirm the color changed
        WebElement colorChangeButton = driver.findElement(By.id("j_idt88:j_idt100"));

    }
}
