package Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utillties.TestBase;

public class D03_AutomationTestingAlerts extends TestBase {
/*
 Go to URL: http://demo.automationtesting.in/Alerts.html
 1. Click "Alert with OK" and click 'click the button to display an alert box'
 2. Accept Alert and print alert text on console
 3. Click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
 4. Cancel Alert
 5. Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
 6. SendKeys "Bootcamp" to the prompt
 7. Print and assert the message "Hello Bootcamp How are you today"
 */
@Test
    void test(){
//    driver.get("http://demo.automationtesting.in/Alerts.html");
//    driver.findElement(By.xpath("//button[@class='btn btn-success navbar-toggle']")).click();
//    driver.switchTo().alert().accept();
//
//    driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
//    driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
//    driver.switchTo().alert().dismiss();
////    click the button to display a confirm box
//    driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
//    driver.switchTo().alert().accept();
//   driver.switchTo().alert().getText();
//    driver.switchTo().alert().sendKeys("Bootcamp");

//    String massage = driver.findElement(By.id("demo1"));
//    System.out.println("Message after prompt = " + message);
//9-6
//    Assertions.assertEquals("Hello Bootcamp How are you today", message);


 driver.get("http://demo.automationtesting.in/Alerts.html");


        driver.findElement(By.xpath("//button[@class='btn btn-success navbar-toggle']")).click(); // الزر الأحمر
    String alertText1 = driver.switchTo().alert().getText();
        System.out.println("Alert with OK text = " + alertText1);
        driver.switchTo().alert().accept();

    // Step 3 & 4: Alert with OK & Cancel
        driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    String alertText2 = driver.switchTo().alert().getText();
        System.out.println("Alert with OK & Cancel text = " + alertText2);
        driver.switchTo().alert().dismiss();


        driver.findElement(By.cssSelector("a.analystic[href='#Textbox']")).click();
        driver.findElement(By.cssSelector("button.btn.btn-info")).click();
        driver.switchTo().alert().sendKeys("Bootcamp");
        driver.switchTo().alert().accept();


    String message = driver.findElement(By.id("demo1")).getText();
        System.out.println("Message after prompt = " + message);
        Assertions.assertEquals("Hello Bootcamp How are you today", message);
}
}

