package Tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utillties.TestBase;

public class D02_CustomerDeletionwithAlerts extends TestBase {
    @Test
    void test(){
       /*
 Go to URL: http://demo.guru99.com/test/delete_customer.php
 Delete customer ID: 123
 Handle 2 alerts that appear
 */
driver.get("http://demo.guru99.com/test/delete_customer.php");
driver.findElement(By.name("cusid")).sendKeys("123");
driver.findElement(By.name("submit")).click();
driver.switchTo().alert().accept();
driver.switchTo().alert().accept();


    }
}
