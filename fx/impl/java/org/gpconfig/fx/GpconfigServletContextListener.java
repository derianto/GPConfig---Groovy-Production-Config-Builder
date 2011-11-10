package org.gpconfig.fx;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Gpconfig servlet context listener.  Purposes: Loading config to Servlets.
 * Author: Derianto Kusuma
 */
public class GpconfigServletContextListener implements ServletContextListener
{
  private static final Logger log = Logger.getLogger(GpconfigServletContextListener.class);

  public void contextInitialized(ServletContextEvent servletContextEvent)
  {
    // Print classpath
    log.info("CLASSPATH:");
    ClassLoader cl = Thread.currentThread().getContextClassLoader();
    URL[] urls = ((URLClassLoader)cl).getURLs();

    for(URL url: urls){
      System.out.println(url.getFile());
    }

    log.info("at GpconfigServletContextListener.contextInitialized");
    // TODO HIGH IMPL
  }

  public void contextDestroyed(ServletContextEvent servletContextEvent)
  {
    log.info("at GpconfigServletContextListener.contextDestroyed");
    // TODO HIGH IMPL
  }
}
