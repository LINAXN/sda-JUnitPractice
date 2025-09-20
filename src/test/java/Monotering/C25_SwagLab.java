package Monotering;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.lang3.exception.ContextedException;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utillties.ActionHelper;
import utillties.TestBase;
import utillties.TestBaseExtentReport;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C25_SwagLab extends TestBaseExtentReport {
    @Test
    void testSwagLab() throws InterruptedException {

//Navigate to
//Log in as the standard user.,
//Capture screenshots of:
//The lowest-priced product (including its image, price, and details).
//The highest-priced product (including its image, price, and details).,

//Log out of the application.,
//Assert each step for validation.,
//Log all steps using Log4j.,
//Generate an Extent Report containing all steps.,


        test = extent.createTest("SwagLab Test", "Validate login and product screenshots");
        ActionHelper action = new ActionHelper(driver);

        try {
            driver.get(" https://www.saucedemo.com/v1/index.html");


            action.sendKeys(By.id("user-name"), "standard_user");
            action.sendKeys(By.id("password"), "secret_sauce");
            action.click(By.id("login-button"));
            test.pass("Logged in successfully", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot("login")).build());


            WebElement dropDown = action.findElement(By.tagName("select"));
            new Select(dropDown).selectByVisibleText("Price (low to high)");
            test.pass("Products sorted by Price (low to high)");


//            WebElement lowest = driver.findElements(By.xpath("//div[@class='inventory_item']")).getFirst();
//    WebElement highest = driver.findElements(By.xpath("//div[@class='inventory_item']")).getLast();


//    takeElementsScreenshot(lowest);
//    takeElementsScreenshot(highest);

//            String lowestProduct = takeElementsScreenshot(lowest, "lowestProduct");
//            String highestProduct = takeElementsScreenshot(highest, "highestProduct");


            List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']"));
            WebElement lowest = products.get(0);
            WebElement highest = products.get(products.size() - 1);

            // Take element screenshots
            String lowestProductPath = takeElementsScreenshot(lowest, "lowestProduct");
            String highestProductPath = takeElementsScreenshot(highest, "highestProduct");

            test.pass("Lowest product is", MediaEntityBuilder.createScreenCaptureFromPath(lowestProductPath).build());
            test.pass("Highest product is", MediaEntityBuilder.createScreenCaptureFromPath(highestProductPath).build());

            // Assertions
            assertTrue(lowest.isDisplayed());
            assertTrue(highest.isDisplayed());
            test.pass("Assertions passed: Products are visible");

            // Logout
            Thread.sleep(3000);
            WebElement Menu = driver.findElement(By.xpath("//button[.='Open Menu']"));
            Menu.click();
//            action.click(By.xpath("//button[.='Open Menu']"));
            WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
            logout.click();
            test.pass("Logged out successfully", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot("logout")).build());

        } catch (Exception ex) {
            test.fail("Test failed: " + ex.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot("error")).build());
            throw ex;
        }
    }}
//@Test
//void test() {
//     /*
//
//Navigate to
//Log in as the standard user.,
//Capture screenshots of:
//The lowest-priced product (including its image, price, and details).
//The highest-priced product (including its image, price, and details).,
//,
//,
//Log out of the application.,
//Assert each step for validation.,
//Log all steps using Log4j.,
//Generate an Extent Report containing all steps.,
//
//
//*/
//
//
//    //i use class action helper to log all steps
//    test = extent.createTest("SwagLab Test", "Validate login and product screenshots");
//    ActionHelper action = new ActionHelper(driver);
//
//
//    driver.get(" https://www.saucedemo.com/v1/index.html");
//
//    driver.findElement(By.id("user-name")).sendKeys("standard_user");
//    driver.findElement(By.id("password")).sendKeys("secret_sauce", Keys.ENTER);
//
//    test.pass("Logged in successfully",
//            com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot("login")).build());
//
//    WebElement dropDown = driver.findElement(By.tagName("select"));
//    new Select(dropDown).selectByVisibleText("Price (low to high)");
//    test.pass("Products sorted by Price (low to high)");
//
//    WebElement lowest = driver.findElements(By.xpath("//div[@class='inventory_item']")).getFirst();
//    WebElement highest = driver.findElements(By.xpath("//div[@class='inventory_item']")).getLast();
//
//
//    takeElementsScreenshot(lowest);
//    takeElementsScreenshot(highest);
//
//    assertTrue(lowest.isDisplayed(), "Lowest product not visible");
//    assertTrue(highest.isDisplayed(), "Highest product not visible");
//    test.pass("Assertions passed: Products are visible");
//
//    driver.findElement(By.xpath("//button[.='Open Menu']")).click();
//    WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
//    logout.click();
//
//    assertTrue(logout.isDisplayed(), "the user is log out !");
//
//
//    test.pass("Logged out successfully",
//            com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot("logout")).build());
//
//
//    test.fail("Test failed: " + e.getMessage(),
//            com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot("error")).build());
//
//}
//}
