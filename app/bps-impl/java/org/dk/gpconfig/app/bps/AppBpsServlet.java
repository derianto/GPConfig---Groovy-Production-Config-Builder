package org.dk.gpconfig.app.bps;

import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * An example servlet.
 * Author: Derianto Kusuma
 */
public class AppBpsServlet extends HttpServlet
{
  private static final Logger log = Logger.getLogger(AppBpsServlet.class);
  // TODO HIGH logging

  @Override
  public void init(ServletConfig config) throws ServletException
  {
    super.init(config);
    log.info("At AppBpsServlet.init()");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    response.setStatus(200);
    response.setContentType("text/html");
    response.getOutputStream().println("<html><body><h1>doGet at AppBpsServlet</h1></body></html>");
    log.info("At AppBpsServlet.doGet()");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    response.setStatus(200);
    response.setContentType("text/html");
    response.getOutputStream().println("<html><body><h1>doPost at AppBpsServlet</h1></body></html>");
    log.info("At AppBpsServlet.doPost()");
  }
}
