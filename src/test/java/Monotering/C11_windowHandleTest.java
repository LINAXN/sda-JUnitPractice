package Monotering;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utillties.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C11_windowHandleTest extends TestBase {
    @Test
    void windowHandleTest(){
//        Go to https://claruswaysda.github.io/
        driver.get("https://claruswaysda.github.io/");

//        Click on Window Handle
driver.findElement(By.linkText("Window Handle")).click();
//        Click on 'Open Index Page'
        Set<String> windowHandle = driver.getWindowHandles();
List<String> wHandle = new ArrayList<>(windowHandle);

driver.switchTo().window(wHandle.get(1));
//        Verify the link 'https://claruswaysda.github.io/index.html'
driver.findElement(By.id("openIndex")).click();
wHandle = new ArrayList<>(driver.getWindowHandles());;
driver.switchTo().window(wHandle.get(2));
        System.out.println(driver.getCurrentUrl());
    }


}
