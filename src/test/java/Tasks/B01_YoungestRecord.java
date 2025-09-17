package Tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utillties.TestBase;

import java.util.List;

public class B01_YoungestRecord extends TestBase {
    @Test
    void YoungestTest(){
         /*
 Go to https://claruswaysda.github.io/addRecordWebTable.html
 Add 10 records using Faker.
 Find the name of the youngest record.
 */
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        Faker faker = new Faker();

        for (int i = 1; i <= 10; i++) {

            String fakeName = faker.name().firstName();
            String fakeAge = String.valueOf(faker.number().numberBetween(1, 99));
            String fakeCountry = faker.country().name();

            driver.findElement(By.id("nameInput")).sendKeys(fakeName);
            driver.findElement(By.id("ageInput")).sendKeys(fakeAge);
            WebElement countryDropdown = driver.findElement(By.id("countrySelect"));
            Select select = new Select(countryDropdown);

            List<WebElement> options = select.getOptions();
            int randomIndex = faker.number().numberBetween(1, options.size());
            select.selectByIndex(randomIndex);

            driver.findElement(By.xpath("//button[@onclick='addRecord()']")).click();
        }

        List<WebElement> rows = driver.findElements(By.xpath("/html/body/table/tbody/tr"));

        int youngestAge = Integer.MAX_VALUE;
        String youngestName = "";

        for (WebElement row : rows) {
            String name = row.findElement(By.xpath("./td[1]")).getText();
            int age = Integer.parseInt(row.findElement(By.xpath("./td[2]")).getText());

            if (age < youngestAge) {
                youngestAge = age;
                youngestName = name;
            }
        }

        System.out.println("Youngest person is: " + youngestName + " with age " + youngestAge);
    }
}



