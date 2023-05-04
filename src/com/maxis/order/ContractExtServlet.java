package com.maxis.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.maxis.log.ContractExtLog;

public class ContractExtServlet
  extends HttpServlet
{
  Log log = LogFactory.getLog(ContractExtServlet.class);

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    ContractExtLog.info("============== Start ContractExtServlet Staging============== ");

    String regId = request.getParameter("regId");
    ContractExtLog.info("=== Staging params passed=== " + regId);

    String status = request.getParameter("status");
    ContractExtLog.info("=== Staging params status=== " + status);

    String transMsid = request.getParameter("transMsid");
    ContractExtLog.info("=== Staging params transMsid=== " + transMsid);

    String paramsregIdQS = request.getQueryString();
    ContractExtLog.info("=== Staging Query String param (may be used in future) === " + paramsregIdQS);

    BrightStarMims bsmims = new BrightStarMims();
    boolean flag = bsmims.updateContractExtPortalTransMsisdn(new Integer(regId), status, new Integer(transMsid));
    ContractExtLog.info("=== Staging resFlag from ContractExt iPhone === " + flag);

    String home_page = "/insertContractExt.jsp";

    ContractExtLog.info("============== End ContractExtServlet Staging================ ");

    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(home_page);
    dispatcher.forward(request, response);
  }
}
