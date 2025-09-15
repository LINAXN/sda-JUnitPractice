package utillties;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

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

public void takeFullPageScreenshot() throws IOException {
    TakesScreenshot screenshot = (TakesScreenshot) driver;     File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
    try {
        FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir")+"\\files\\secreenshots\\pages_screenshot.png"));
    }  catch (IOException e){
        throw new RuntimeException(e);
    }


}
}
