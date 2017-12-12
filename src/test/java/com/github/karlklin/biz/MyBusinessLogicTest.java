package com.github.karlklin.biz;

import com.github.karlklin.Acceptance;
import org.junit.jupiter.api.*;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Acceptance
@DisplayName("My Fancy Business Logic Test Case")
class MyBusinessLogicTest {

    private MyBusinessLogic businessLogic;

    @BeforeAll
    static void setUpAll() {
        System.out.println("set up all");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("tear down all");
    }

    @BeforeEach
    void setUp() {
        System.out.println("set up");

        businessLogic = new MyBusinessLogic();
    }

    @Test
    @DisplayName("checks asserts for exception")
    void shouldThrowException() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            businessLogic.businessMethodThatThrowsException();
        });

        // also it is possible to provide upper exception class
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            businessLogic.businessMethodThatThrowsException();
        });

        assertEquals(exception.getMessage(), "Not supported");
    }

    @Test
    void assertThrowsException() {
        String str = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Integer.valueOf(str);
        });
    }

    @Test
    void groupAssertion() {
        // Grouped assertion, so processed independently
        // of results of first name assertions.
        assertAll("group assertion",
                () -> {
                    assertEquals(1, 1);

                    //executed only if previous assertion is true
                    assertTrue(true);
                },
                () -> assertEquals(2, 2));
    }

    @Test
    void testOnlyOnDeveloperWorkstation() {
        assumeTrue("DEV".equals(System.getenv("ENV")),
                () -> "Aborting test: not on developer workstation");
        // remainder of test

        throw new RuntimeException("runtime exception");
    }

    @Test
    void reportSeveralValues(TestReporter testReporter) {
        HashMap<String, String> values = new HashMap<>();
        values.put("user name", "dk38");
        values.put("award year", "1974");

        testReporter.publishEntry(values);
    }

    @AfterEach
    void tearDown() {
        System.out.println("tear down");
    }
}
