package org.eclipse.krazo.examples.undertow;

import org.eclipse.krazo.engine.ViewEngineFinder;
import org.junit.jupiter.api.Test;

import javax.mvc.engine.ViewEngine;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Gregor Tudan, Cofinpro AG
 */
class MvcApplicationTest {

    private MvcApplication mvcApplication = new MvcApplication();

    @Test
    void getClasses() {
        assertNotNull(mvcApplication.getClasses());
        assertFalse(mvcApplication.getClasses().isEmpty());
    }

    @Test
    void getProperties() {
        assertTrue(mvcApplication.getProperties().containsKey(ViewEngine.VIEW_FOLDER));
    }
}