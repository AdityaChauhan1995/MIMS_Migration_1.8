package com.maxis.order;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EbdPortalConsumerOrderServlet
  extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    System.out.println("======= QUERY_STRING ======= " + request.getQueryString());

    response.setContentType("text/plain");

    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<head>");

    String title = "EbdPortalConsumerOrdering";
    out.println("<title>" + title + "</title>");
    out.println("</head>");
    out.println("<body bgcolor=\"white\">");

    out.println("<h3>" + title + "</h3>");

    String queryString = "param1";
    out.println("<font color=gray>Parameter in URL </font><br>");
    if (queryString != null)
    {
      out.println("<font color=gray>Query String from URL</font>");
      out.println(" ===>     { <font color=blue>" + HTMLFilter.filter(request.getQueryString()) + "</font> } <br>");
    }
    else
    {
      out.println("No Parameters from URL");
    }
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}
