package org.eclipse.krazo.examples.undertow;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Gregor Tudan
 */
@ExtendWith(ServerExtension.class)
class ControllerIT {

   @Test
   void testHello(URL baseURL) throws IOException {
      try (final WebClient webClient = new WebClient()) {
         final HtmlPage page = webClient.getPage(baseURL + "/hello");
         final String pageAsText = page.asText();
         assertTrue(pageAsText.contains("Hello World"));
      }
   }

   @Test
   void testHelloWithParameter(URL baseURL) throws IOException {
      try (final WebClient webClient = new WebClient()) {
         final HtmlPage page = webClient.getPage(baseURL + "hello?name=Gregor");
         final String pageAsText = page.asText();
         assertTrue(pageAsText.contains("Hello Gregor"));
      }
   }
}
