package com.github.karlklin.biz;

import com.github.karlklin.Acceptance;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Acceptance
class MyBusinessLogicTest {

    private MyBusinessLogic businessLogic;

    @BeforeAll
    static void setUpAll() {
        System.out.println("set up all");
    }

    @BeforeEach
    void setUp() {
        System.out.println("set up");

        businessLogic = new MyBusinessLogic();
    }

    @Test
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

    @AfterEach
    void tearDown() {
        System.out.println("tear down");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("tear down all");
    }
}
