package org.gpconfig.fx;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

/**
 * Gpconfig servlet context listener.  Purposes: Loading config to Servlets.
 * Author: Derianto Kusuma
 */
public class GpconfigServletContextListener implements ServletContextListener
{
  private static final Logger log = Logger.getLogger(GpconfigServletContextListener.class);

  public void contextInitialized(ServletContextEvent servletContextEvent)
  {
    log.info("at GpconfigServletContextListener.contextInitialized");

    // DEBUG Print classpath
    log.info("CLASSPATH:");
    ClassLoader cl = Thread.currentThread().getContextClassLoader();
    URL[] urls = ((URLClassLoader)cl).getURLs();

    for(URL url: urls){
      log.info("  " + url.getFile());
    }

    // Load config
    Map<String, Object> config = loadConfig(servletContextEvent.getServletContext());
    log.info("LOADED CONFIG:");
    for (String s: config.keySet())
    {
      log.info("  " + s + " => " + config.get(s));
    }
  }

  private Map<String, Object> loadConfig(ServletContext servletContext)
  {
    String configFilename = "properties.json";
    log.info("getRealPath = " + servletContext.getRealPath("."));
    String configDir = new File(servletContext.getRealPath(".")).getParent();
    log.info("getConfigDir = " + configDir);

    File file = new File(configDir, configFilename);
    FileInputStream inputStream;
    try
    {
      inputStream = new FileInputStream(file);
      if (inputStream == null)
      {
        log.error("Fail to get config with name " + configFilename + " in " + configDir);
        return null;
      }
    }
    catch (FileNotFoundException e)
    {
      log.error("Fail to get config with name " + configFilename + " in " + configDir);
      return null;
    }

    ObjectMapper objectMapper = new ObjectMapper();
    Map<String, Object> map = new HashMap<String, Object>();
    try
    {
      map = objectMapper.readValue(inputStream, Map.class);
    }
    catch (IOException e)
    {
      log.error("Fail to parse config", e);
    }
    return map;
  }

  public void contextDestroyed(ServletContextEvent servletContextEvent)
  {
    log.info("at GpconfigServletContextListener.contextDestroyed");
  }
}
