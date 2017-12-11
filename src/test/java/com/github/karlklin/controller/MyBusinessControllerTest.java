package com.github.karlklin.controller;

import com.github.karlklin.biz.controller.MyBusinessController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("integration")
public class MyBusinessControllerTest {

    private MyBusinessController controller;

    @BeforeEach
    public void setUp() {
        controller = new MyBusinessController();
    }

    @Test
    public void testTransform() {
        assertEquals(controller.transform(), "transformed");
    }

}
