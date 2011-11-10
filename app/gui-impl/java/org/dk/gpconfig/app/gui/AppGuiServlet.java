package org.dk.gpconfig.app.gui;

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
public class AppGuiServlet extends HttpServlet
{
  // TODO HIGH logging

  @Override
  public void init(ServletConfig config) throws ServletException
  {
    super.init(config);
    System.out.println("At AppGuiServlet.init()");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    response.setStatus(200);
    response.setContentType("text/html");
    response.getOutputStream().println("<html><body><h1>doGet at AppGuiServlet</h1></body></html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    response.setStatus(200);
    response.setContentType("text/html");
    response.getOutputStream().println("<html><body><h1>doPost at AppGuiServlet</h1></body></html>");
  }
}
