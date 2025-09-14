package Monotering;

import org.junit.jupiter.api.Test;
import utillties.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C16_Cookies extends TestBase {
    @Test
    void cookieTest(){
        //        Go to
driver.get("https://claruswaysda.github.io/CookiesWait.html");
//        Accept the alert if it is present
        try {
            driver.switchTo().alert().accept();
            System.out.println("appear!");
        }catch (Exception ignored){
            System.out.println("not appear");
        }

//        Print the cookies
        System.out.println(driver.manage().getCookies());
//        Delete all cookies and assert
driver.manage().deleteAllCookies();
assertEquals(0,driver.manage().getCookies().size());


    }
}
