package Monotering;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utillties.TestBase;

public class C07_JSAlert extends TestBase {
    @Test
    void test() {
//     /*
//Go to https://claruswaysda.github.io/ActionsForm.html
        driver.get("https://claruswaysda.github.io/ActionsForm.html");
//Fill the form
        driver.findElement(By.id("name")).sendKeys("lina");
        driver.findElement(By.id("age")).sendKeys("Lina1234");
        new Select(driver.findElement(By.id("options"))).selectByVisibleText("IT Department");
        WebElement coding = driver.findElement(By.xpath("//input[@value='coding']"));
        if (!coding.isSelected()) {
            coding.click();
        }
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.xpath("//button[@onclick='generatePasscode()']")).click();
        String passcode = driver.switchTo().alert().getText().replaceAll("\\D", "");
//        System.out.println("passcode = " + passcode);
        driver.switchTo().alert().accept();
        driver.switchTo().alert().sendKeys(passcode);
        driver.switchTo().alert().accept();


        WebElement iFrame = driver.findElement(By.xpath("//iframe[@name='iframeSubmit']"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.id("submitButton")).click();//This element is inside an iframe!

        driver.switchTo().parentFrame();


    }
}
