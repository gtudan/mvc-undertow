package org.eclipse.krazo.examples.undertow;

import org.eclipse.krazo.core.ModelsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Gregor Tudan
 */
class HelloControllerTest {

    private HelloController controller;

    @BeforeEach
    void setUp() {
        controller = new HelloController(new ModelsImpl());
    }

    @Test
    void testHelloController() {
        final String result = controller.hello("World");
        assertEquals("hello.html", result);
    }
}