package org.eclipse.krazo.examples.undertow;

import io.undertow.Undertow;
import io.undertow.server.handlers.resource.ClassPathResourceManager;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import org.jboss.resteasy.core.ResteasyDeploymentImpl;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.jboss.weld.environment.servlet.Listener;


/**
 * @author Gregor Tudan
 */
public class Server {

    private UndertowJaxrsServer server = new UndertowJaxrsServer();

    public Server(String host, int port) {
        Undertow.Builder undertow = Undertow.builder()
                .addHttpListener(port, host);
        server.start(undertow);
    }

    public static void main(String[] args) {
        final Server server = new Server("localhost", 8080);
        server.deploy();
    }

    public void deploy() {
        ResteasyDeployment deployment = new ResteasyDeploymentImpl();
        deployment.setApplicationClass(MvcApplication.class.getName());
        deployment.setInjectorFactoryClass("org.jboss.resteasy.cdi.CdiInjectorFactory");

        DeploymentInfo deploymentInfo = server.undertowDeployment(deployment, "/")
                .setClassLoader(Server.class.getClassLoader())
                .setResourceManager(new ClassPathResourceManager(Server.class.getClassLoader()))
                .setDeploymentName("MVC-Test")
                .setContextPath("/")
                .addListener(Servlets.listener(Listener.class));

        server.deploy(deploymentInfo);
    }

    public void shutdown() {
        server.stop();
    }
}
