package org.eclipse.krazo.examples.undertow;

import javax.mvc.engine.ViewEngine;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * @author Gregor Tudan
 */
public class MvcApplication extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(HelloController.class);
    }

    @Override
    public Map<String, Object> getProperties() {
        return Collections.singletonMap(ViewEngine.VIEW_FOLDER,"views");
    }
}
