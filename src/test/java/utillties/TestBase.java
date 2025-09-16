package utillties;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class TestBase {

    protected  WebDriver driver;


    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }
    public void takeFullPageScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        String now = new SimpleDateFormat("yyyyMMddhhmmssSSSSS").format(new Date());
        try {
            FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir") + "\\test_outputs\\screenshots\\pages_screenshot" + now + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void takeElementsScreenshot(WebElement element) {
        File screenshot = element.getScreenshotAs(OutputType.FILE);
        String now = new SimpleDateFormat("yyyyMMddhhmmssSSSSS").format(new Date());
        try {
            FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "\\test_outputs\\screenshots\\elements_screenshot" + now + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void takeScreenShot(WebDriver driver) {
        TakesScreenshot ss =(TakesScreenshot)driver;
        File screenFile = ss.getScreenshotAs(OutputType.FILE);
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd:HH-mm-ss"));
        String screenShotName = "Screenshot"+timeStamp+ ".png";
        Path screenShotPath = Path.of(System.getProperty("user.dir"),"target","test-output","screenshots",screenShotName);

        try {
            FileUtils.copyFile(screenFile,screenShotPath.toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    protected void takeScreenshotOfElement(WebDriver driver, WebElement element) {
        File screenShotFile = element.getScreenshotAs(OutputType.FILE);
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd:HH-mm-ss"));
        String screenShotName = "ElementScreenshot"+timeStamp+ ".png";
        Path screenShotPath = Path.of(System.getProperty("user.dir"),"target","test-output","screenshots",screenShotName);

        try {
            FileUtils.copyFile(screenShotFile,screenShotPath.toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}



