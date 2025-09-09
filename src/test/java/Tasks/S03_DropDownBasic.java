package Tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class S03_DropDownBasic {
//    Go to https://the-internet.herokuapp.com/dropdown
//    Create selectByIndexTest method - Select Option 1 using index
//    Create selectByValueTest method - Select Option 2 by value
//    Create selectByVisibleTextTest method - Select Option 1 by visible text
//    Create printAllTest method - Print all dropdown values
//    Verify dropdown has Option 2 text
//    Create printFirstSelectedOptionTest - Print first selected option
//    Verify dropdown size equals 3 elements
    WebDriver driver;
    @Test
    void test(){
        driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dd = driver.findElement(org.openqa.selenium.By.id("dropdown"));
        Select select = new Select(dd);
        select.selectByIndex(1);
        select.selectByValue("2");
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        select.getOptions().forEach(t-> System.out.println(t.getText()));
        assert select.getOptions().stream().anyMatch(t->t.getText().equals("Option 2"));
        System.out.println(select.getFirstSelectedOption().getText());
        assert select.getOptions().size()==3;
        driver.quit();

    }

}
