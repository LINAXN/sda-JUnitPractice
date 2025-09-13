package Tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utillties.TestBase;

import java.util.List;

public class S05_MultiSelect extends TestBase {
//    Launch browser
//    Open
//    Select Standard Multi-Select using element id
//    Verify element is multi-select
//    Select 'Opel' using index, then deselect using index
//    Select 'Saab' using value, then deselect using value
//    Deselect all options
//    Close browse
//

    @Test
    void test(){
  driver.get("https://demoqa.com/select-menu");
//        List<WebElement> multiSelect=  driver.findElements(By.id("cars"));
//        System.out.println(multiSelect.is);
        WebElement multiSelect = driver.findElement(By.id("cars"));

        Select select = new Select(multiSelect);

        // Verify element is multi-select
        System.out.println("Is multiple? " + select.isMultiple());
select.selectByIndex(2);
select.selectByValue("saab");
        select.deselectAll();

    }
}
