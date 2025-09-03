package TestSession;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_ContactList {
/*
Task:
Open the Chrome driver in @BeforeAll method
Go to https://thinking-tester-contact-list.herokuapp.com/
 in @BeforeEach method
Check the title in test01 method
Check the link in test02 method
Check the page source in test02 method
Close the browser in @AfterAll method
 */

    static WebDriver driver;
    @BeforeAll
    public static void CheckContactList() {
        driver = new ChromeDriver();
    }


    @BeforeEach
    void gotoContactList() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
    }

    @Test
    public void test01() {
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        if (title.equals("Contact List App")) {
            System.out.println("Title test PASSED");
        } else {
            System.out.println("Title test FAILED");
        }
    }

    @Test
    public void test02() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        if (currentUrl.equals("https://thinking-tester-contact-list.herokuapp.com/")) {
            System.out.println("URL test PASSED");
        } else {
            System.out.println("URL test FAILED");
        }
        String pageSource = driver.getPageSource();
        if (pageSource.contains("Contact List")) {
            System.out.println("Page source test PASSED");
        } else {
            System.out.println("Page source test FAILED");
        }
    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
