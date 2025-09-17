package Monotering;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utillties.TestBase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C23_TotalPrice extends TestBase {
    /*
    Go to https://claruswaysda.github.io/webTable.html
    Calculate and assert the total price in Table 2.
    */

    @Test
    void tableTotalPriceTest() {

//        Go to https://claruswaysda.github.io/webTable.html

driver.get("https://claruswaysda.github.io/webTable.html");

//        Calculate and assert the total price in Table 2.
        List<WebElement> Price = driver.findElements(By.xpath("//table[2]//tr/td[3]"));
        int sum= 0;

        for (WebElement num : Price) {
            String priceText = num.getText().replace("$", "").trim();
            int pricetotal = Integer.parseInt(priceText);
            sum += pricetotal;
        }
        System.out.println("Total = " + sum);
        assertEquals(2275, sum);

    }
}
