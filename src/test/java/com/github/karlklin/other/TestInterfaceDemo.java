package com.github.karlklin.other;

import com.github.karlklin.Acceptance;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Acceptance
public class TestInterfaceDemo implements TestLifecycleLogger {

    @Test
    void testMethod() {
        assertEquals(1, 1, "is always equal");
    }
}
