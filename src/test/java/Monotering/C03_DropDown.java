package Monotering;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {


    static WebDriver driver;
@Test
void test01() {
    driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
    WebElement dd = driver.findElement(By.name("dropdown"));
    Select select = new Select(dd);
    select.selectByIndex(2);
    select.selectByValue("dd5");
    select.selectByVisibleText("Drop Down Item 6");
    System.out.println(select.getFirstSelectedOption().getText());
    List<WebElement> options = select.getOptions();
    options.forEach(t-> System.out.println(t.getText()));System.out.println("select.isMultiple() = " + select.isMultiple());

    Select selectMultiple =new Select(driver.findElement(By.name("multipleselect[]")));
    System.out.println("selectMultiple.isMultiple() = " + selectMultiple.isMultiple());
}



    @BeforeAll
    static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @AfterAll
    static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
