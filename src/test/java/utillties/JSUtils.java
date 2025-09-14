package utillties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSUtils {
    public static void flash(WebElement element, WebDriver driver, String color) throws InterruptedException {
        String originalColor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(300);
            changeBGColor(element, driver, color);
            changeBGColor(element, driver, originalColor);
        }

    }

    public static void changeBGColor(WebElement element, WebDriver driver, String color) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor= '" + color + "'", element);
    }

    public static void changeBorderStyleColor(WebDriver driver, WebElement element, String px, String style, String color) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='" + px + " " + style + " " + color + "'", element);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeBorder(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='none'", element);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void flashBorder(WebDriver driver, WebElement element, String s, String dashed, String red) {
        for (int i = 0; i < 20; i++) {
            changeBorderStyleColor(driver, element, "3px", "dashed", "red");
            removeBorder(driver, element);
        }
    }
}