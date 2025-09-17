package Monotering;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utillties.TestBase;

import java.util.Arrays;
import java.util.List;

public class C22_WebTableArray extends TestBase {
    @Test
    void webTableArray() {
        //        Go to
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        Faker faker = new Faker();
//        Add 10 records.
        for (int i = 1; i <= 10; i++) {

            String fakeName = faker.name().firstName();
            String fakeAge = String.valueOf(faker.number().numberBetween(1, 99));
            String fakeCountry = faker.country().name();

            driver.findElement(By.id("nameInput")).sendKeys(fakeName);
            driver.findElement(By.id("ageInput")).sendKeys(fakeAge);
            WebElement countryDropdown = driver.findElement(By.id("countrySelect"));
            Select select = new Select(countryDropdown);

            List<WebElement> options = select.getOptions();
            int randomIndex = faker.number().numberBetween(1, options.size()); // نتجنب index=0 لأنه placeholder
            select.selectByIndex(randomIndex);

            driver.findElement(By.xpath("//button[@onclick='addRecord()']")).click();
        }


//        Store the name, age, and country columns in separate arrays (not ArrayList).

                List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
        String[] names = new String[rows.size()];
        String[] ages = new String[rows.size()];
        String[] countries = new String[rows.size()];

        for (int i = 0; i < rows.size(); i++) {
            names[i] = rows.get(i).findElement(By.xpath(".//td[1]")).getText();
            ages[i] = rows.get(i).findElement(By.xpath(".//td[2]")).getText();
            countries[i] = rows.get(i).findElement(By.xpath(".//td[3]")).getText();
        }

        System.out.println("names = " + Arrays.toString(names));
        System.out.println("ages = " + Arrays.toString(ages));
        System.out.println("countries = " + Arrays.toString(countries));

    }

    }
