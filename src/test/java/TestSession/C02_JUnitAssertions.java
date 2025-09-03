package TestSession;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class C02_JUnitAssertions {
    @Test
    public void assertEqualsTest() {
        String actual = "java";
        String expected = "java2";
        Assertions.assertEquals(expected, actual, "it is NOT equal");
    }

    @Test
    public void assertTrueTest() {
String Table= """
        First Name  Last Name   Date of Birth
        John        Doe         2000-05-15
        Mary        Moe         1985-10-30
        """;
Assertions.assertTrue(Table.contains("Johnq"),"it does NOT contain");
    }
    @Test
    public void assertFalseTest() {
        int a=10;
        int b=20;
        Assertions.assertFalse(a>b,"a is NOT greater than b");
    }
    @Test
    public void assertNullTest() {
        String str="java";
        Assertions.assertNotNull(str,"it is null");
    }
}