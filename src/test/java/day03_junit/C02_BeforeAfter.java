package day03_junit;

import org.junit.jupiter.api.*;

public class C02_BeforeAfter {

    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll notasyonuna sahip olan bir method, tum test methodlarindan once bir kez calistirilir.");

    }

    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach notasyonuna sahip olan bir method, her bir test methodlarindan once bir kez calistirilir.");
    }


    @Test
    void test1() {
        System.out.println("Test 1 calisti");

    }

    @Test
    void test2() {
        System.out.println("Test 2 calisti");

    }


    @Test @Disabled
    void test3() {
        System.out.println("Test 3 calisti");

    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach notasyonuna sahip olan bir method, her bir test methodlarindan sonra bir kez calistirilir.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll notasyonuna sahip olan bir method, tum test methodlarindan sonra bir kez calistirilir.");
    }



}
