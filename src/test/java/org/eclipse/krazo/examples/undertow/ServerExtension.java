package org.eclipse.krazo.examples.undertow;

import org.junit.jupiter.api.extension.*;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Boots up the server for testing
 *
 * @author Gregor Tudan
 */
public class ServerExtension implements BeforeAllCallback, AfterAllCallback, ParameterResolver {
    private static final int PORT = 8080;
    private static final String HOST = "localhost";
    private Server server = new Server(HOST, PORT);

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        server.shutdown();
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        server.deploy();
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(URL.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        try {
            return new URL("http", HOST, PORT, "/");
        } catch (MalformedURLException e) {
            throw new ParameterResolutionException("Failed to create Base-URL", e);
        }
    }
}
