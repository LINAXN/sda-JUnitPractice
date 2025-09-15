package TestSession;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utillties.TestBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C39_SecreenShot extends TestBase {
//Go to Google
//Take full page screenshot
//Take a specific element's screenshot
//        */

@Test
public void screenShotTest() throws IOException {
    //       Go to Clarusway
    driver.get("https://opensource-demo.orangehrmlive.com");
    TakesScreenshot ss =(TakesScreenshot) driver;
String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd:HH-mm-ss"));
    File screenshot = ss.getScreenshotAs(OutputType.FILE);
    Path path = Path.of(System.getProperty("user.dir"),"target","screenshot","lastscreen.png");
    FileUtils.copyFile(screenshot,path.toFile());

    //       Take full page screenshot
    //FileUtils.copyFile(screenShot,new File("./target/test-output/googleSs.png"));

    //       Take a specific element's screenshot
}
}