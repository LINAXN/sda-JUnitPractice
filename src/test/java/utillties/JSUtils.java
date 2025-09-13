package utillties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSUtils {
    public static void flash(WebElement element, WebDriver driver, String color) throws InterruptedException {
        String originalColor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(300);
            changecolor(element,driver,color);
            changecolor(element,driver,originalColor);
        }

    }

    public static void changecolor(WebElement element, WebDriver driver, String color) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor= '" + color + "'", element);
    }
}