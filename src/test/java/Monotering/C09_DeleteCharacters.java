package Monotering;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utillties.TestBase;

public class C09_DeleteCharacters extends TestBase {
    @Test
    void test01() {
   /*
 Go to https://claruswaysda.github.io/deleteChars.html
 Enter your full name
 Delete the letters
 Verify the message 'Deleted'
 */
        driver.get("https://claruswaysda.github.io/deleteChars.html");
        //TODO send your full name
        String fullName = "John Doe";
        driver.findElement(By.tagName("input")).sendKeys(fullName);
        driver.findElement(By.xpath("//button[@id='enterButton']")).click();
        //TODO delete the letters
        WebElement deleteButton = driver.findElement(By.xpath("//button[@id='deleteButton']"));
        for (int i = 0; i < fullName.length(); i++) {
            //TODO verify the message 'Deleted'
            deleteButton.click();
        }

        assert driver.findElement(By.xpath("//*[.='Deleted']")).isDisplayed();


    }
}