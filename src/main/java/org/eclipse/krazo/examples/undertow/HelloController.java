package org.eclipse.krazo.examples.undertow;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * @author Gregor Tudan
 */
@Path("/hello")
@Controller
public class HelloController {

    @Inject
    private Models models;

    @GET
    public String hello(@QueryParam("name") @DefaultValue("World") String name) {
        models.put("name", name);
        return "hello.html";
    }
}
