import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {

    WebDriver driver;

    @BeforeMethod
    public void openTextBoxTestPage() throws InterruptedException {
        //change browser version to remove warning
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setBrowserVersion("124");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
        Thread.sleep(3000);
    }

    @Test
    public void testTextBox(){
        //01. Type your name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Samitha");

        //02. Append Country to this City
        WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys(" SriLanka");

        //03. Verify if text box is disabled
        boolean enabled = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is textbox is enabled: "+ enabled);

        //04. Clear the typed text
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //05. Retrieve the typed text
        WebElement getTypedText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt97']"));
        String typedText = getTypedText.getAttribute("value");
        System.out.println("Typed text is: "+ typedText);

        //06. Type email and Tab. Confirm control moved to next element
        WebElement emailText = driver.findElement(By.id("j_idt88:j_idt99"));
        emailText.sendKeys("samitha@gmail.com"+ Keys.TAB + "Confirm control moved to next element");

        //07. Type about yourself

        //08. Text Editor

        //09. Just Press Enter and confirm error message*

        //10. Click and Confirm Label Position Changes

        //11. Type your name and choose the third option

        //12. Type your DOB (mm/dd/yyyy) and confirm date chosen

        //13. Type number and spin to confirm value changed

        //14. Type random number (1-100) and confirm slider moves correctly

        //15. Click and Confirm Keyboard appears

        //16. Custom Toolbar
    }
}
