package com.github.karlklin.biz;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyBusinessLogicTest {

    private MyBusinessLogic businessLogic;

    @BeforeAll
    public static void setUpAll() {
        System.out.println("set up all");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("set up");

        businessLogic = new MyBusinessLogic();
    }

    @Test
    public void shouldThrowException() {
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
    public void assertThrowsException() {
        String str = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Integer.valueOf(str);
        });
    }

    @AfterEach
    public void tearDown() {
        System.out.println("tear down");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("tear down all");
    }
}
