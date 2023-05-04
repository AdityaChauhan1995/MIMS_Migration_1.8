package com.maxis.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ClientPost
  extends HttpServlet
{ 
  Log log = LogFactory.getLog(ClientPost.class);

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    this.log.info("============== Came to Servlet ClientPost Staging============== ");

    String paramsregId = request.getParameter("id");
    this.log.info("=== Staging params passed=== " + paramsregId);

    String status = request.getParameter("status");
    this.log.info("=== Staging params status=== " + status);

    String orderNo = request.getParameter("orderNo");
    this.log.info("=== Staging params orderNo=== " + orderNo);
    

    String deviceOrderNo = request.getParameter("deviceOrderNo");
    this.log.info("=== Staging params deviceOrderNo=== " + deviceOrderNo);
    
    String paramsregIdQS = request.getQueryString();
    this.log.info("=== Staging Query String param (may be used in future) === " + paramsregIdQS);

    BrightStarMims bsmims = new BrightStarMims();
    boolean flag = false;
    if (status.equalsIgnoreCase("S"))
    {
      this.log.info("=== status === " + status + "=== for orderNo ===" + orderNo);
      flag = bsmims.update_PORTAL_TRANS_PHONE_ORDER_S(new Integer(paramsregId), status, new Integer(orderNo), deviceOrderNo);
    }
    else if (status.equalsIgnoreCase("M"))
    {
      this.log.info("=== status === " + status + "=== for orderNo ===" + orderNo);
      flag = bsmims.update_PORTAL_TRANS_PHONE_ORDER_M(new Integer(paramsregId), status, new Integer(orderNo));
    }
    else
    {
      this.log.info("=== Nothing updated status === " + status + "=== for orderNo ===" + orderNo);
    }
    this.log.info("=== Staging resFlag from BrightStarMims === " + flag);

    String home_page = "/home.jsp";

    this.log.info("============== End ClientPost Staging================ ");

    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(home_page);
    dispatcher.forward(request, response);
  }
}
