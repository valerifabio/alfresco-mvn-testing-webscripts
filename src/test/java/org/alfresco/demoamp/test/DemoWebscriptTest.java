package org.alfresco.demoamp.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.alfresco.repo.web.scripts.BaseWebScriptTest;
import org.apache.log4j.Logger;
import org.springframework.extensions.webscripts.TestWebScriptServer;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.extensions.webscripts.Status;

/**
 *
 * @author Fabio Valeri
 */
public class DemoWebscriptTest extends BaseWebScriptTest {
  
  static Logger log = Logger.getLogger(DemoWebscriptTest.class);

  private static final String ADMIN_USER_NAME = "admin";
  private static final String DEMO_WEBSCRIPT_URL = "/demowebscript";
  private static final Map<String, String> DEMO_WEBSCRIPT_ARGS = new HashMap<String, String>() {
    {
      put("message", "Hello");
    }
  };
  private static final TestWebScriptServer.Request DEMO_WEBSCRIPT_REQUEST = new TestWebScriptServer.GetRequest(DEMO_WEBSCRIPT_URL).setArgs(DEMO_WEBSCRIPT_ARGS);
  private static final String JSON_RESULT = "result";

  public DemoWebscriptTest() {
    super();
  }

  @Test
  public void testDemoWebscript() {
    log.debug("DemoWebscriptTest.testDemoWebscript");
    try {
      TestWebScriptServer.Response response = sendRequest(DEMO_WEBSCRIPT_REQUEST, Status.STATUS_OK, ADMIN_USER_NAME);
      assertEquals("Hello from Demo Webscript", new JSONObject(response.getContentAsString()).getString(JSON_RESULT));
    } catch (IOException ex) {
      log.warn("IOException", ex);
    } catch (JSONException ex) {
      log.warn("JSONException", ex);
    }
  }
  

}
