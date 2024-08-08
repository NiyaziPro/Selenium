package day04_assertions_webelements_locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C01_Assertions {
    /*
        JUnit 4'te Assertion ile dogrulama yaparken, Assert.True - Assert.equals gibi methodlari
        çağırmak için "Assert" classı kullanılıyordu.
        Junıt5te ise  "Assertions" classsı kullanılıyor.
     */

    @Test
    void test01() {

        String expectedData = "Hello Selenium :)";

        String actualData = "Hello Selenium :)";

        Assertions.assertEquals(expectedData, actualData);
    }

    @Test
    void test02() {

        int number = 5;
        Assertions.assertTrue(number > 0);
    }

    @Test
    void test03() {

        Assertions.assertFalse("selenium".contains("E"));
    }

    @Test
    void test04() {

        Assertions.assertNotEquals("Selenium", "selenium".toUpperCase());
    }

    @Test
    void test05() {

        int[] expectedArray = {1, 2, 3, 4, 5};
        int[] actualArray = {1, 2, 3, 4, 5};

        char[] expectedArray1 = {'a', 'b', 'c'};
        char[] actualArray1 = {'a', 'b', 'b'};

        Assertions.assertArrayEquals(expectedArray, actualArray);
        // İki arrayin birbirine eşit olabilmesi için, aynı indexte aynı değerler olmalı.
    }

    @Test
    void test06() {
        String str = null;

        Assertions.assertNull(str);
        // Parantez içindeki değer null ise test geçer, değilse test kalır.
    }

    @Test
    void test07() {

        String str ="";
        Assertions.assertNotNull(str);

        // Parantez içindeki değer null ise test kalır , değilse test geçer.
    }
}
