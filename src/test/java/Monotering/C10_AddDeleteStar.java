package Monotering;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utillties.TestBase;


public class C10_AddDeleteStar extends TestBase {
    @Test
    void test() {
 /*
 Go to https://claruswaysda.github.io/addDeleteStar.html
 Create a method to add given number of stars
 Create a method to delete given numbers of stars
 Create a method to verify the given number of stars deleted
 */
        driver.get("https://claruswaysda.github.io/addDeleteStar.html");

       int add= AddStar(50);
       int delete= DeleteStar(40);
        System.out.println(NumberStars(add,delete));

    }

    int AddStar(int numOfstars) {
        WebElement addStar = driver.findElement(By.xpath("//button[@class='circle-button']"));
        for (int i = 0; i < numOfstars; i++) {
            addStar.click();
        }
        return numOfstars;
    }

    int DeleteStar(int numOfstars){
        WebElement deleteStar = driver.findElement(By.xpath("//button[@class='delete-button']"));
        for (int i = 0; i < numOfstars; i++) {
            deleteStar.click();
        }
        return numOfstars;

    }
    boolean NumberStars( int adde , int delete  ){
        return adde - delete == driver.findElements(By.xpath("//div[@class='star']")).size();

    }
}
