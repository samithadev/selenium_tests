import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {

    WebDriver driver;

    @BeforeMethod
    public void openTestBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/select.xhtml");
    }

    @Test
    public void testDropDownInLeafGround(){

        //1.1) ways to select values in basic dropdown
        WebElement dropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Cypress");

        //1.2) Get the no of dropdown options
        List<WebElement> listOfOptions = select.getOptions();
        int noOfOptions = listOfOptions.size();
        System.out.println("No of dropdown options: "+ noOfOptions);
        for( WebElement element :listOfOptions){
            System.out.println(element.getText());
        }

        //1.3) using send keys select dropdown value
        dropDown.sendKeys("Cypress");

        //1.4) selecting value in bootstrap dropdown
        WebElement bootstrapDropDown = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        bootstrapDropDown.click();
        List<WebElement> listOfValues = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for(WebElement listValue: listOfValues){
            String dropDownValue = listValue.getText();

            if(dropDownValue.equals("USA")){
                listValue.click();
                break;
            }
        }
    }

    //2) Google search - pick a value from suggestions
    @Test
    public void googleSearchDropDownTest() throws InterruptedException {

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebElement googleSearch = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        googleSearch.sendKeys("palitha");
        Thread.sleep(2000);

        List<WebElement> googlesearchList = googleSearch.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']"));
        System.out.println(googlesearchList.size());;
        for(WebElement element: googlesearchList){
            if(element.getText().contains("Palitha Thewarapperuma")){
                element.click();
                break;
            }
        }

    }

    //3) Handle hidden auto suggestions Drop Down and search using DOM debugger trick

}
