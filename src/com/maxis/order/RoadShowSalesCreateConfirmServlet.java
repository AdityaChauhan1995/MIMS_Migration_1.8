package com.maxis.order;

import com.maxis.log.RoadShowLogUtil;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RoadShowSalesCreateConfirmServlet
  extends HttpServlet
{
  protected Log log = LogFactory.getLog(RoadShowSalesCreateConfirmServlet.class);
  private static String message = "Error During RoadShowSalesCreateConfirmServlet Processing";

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    String paramsregId = request.getParameter("id");
    RoadShowLogUtil.info("=== Staging params passed=== " + paramsregId);

    String status = request.getParameter("status");
    RoadShowLogUtil.info("=== Staging params status=== " + status);

    String orderNo = request.getParameter("orderNo");
    RoadShowLogUtil.info("=== Staging params orderNo=== " + orderNo);

    String paramsregIdQS = request.getQueryString();
    RoadShowLogUtil.info("=== Staging Query String param (may be used in future) === " + paramsregIdQS);

    RoadShowUpdateMims bsmims = new RoadShowUpdateMims();
    boolean flag = false;
    if ((status.equalsIgnoreCase("S")) && (orderNo.length() > 0))
    {
      RoadShowLogUtil.info("=== status === " + status + "=== for orderNo ===" + orderNo);
      flag = bsmims.update_PORTAL_TRANS_PHONE_ORDER_S(new Integer(paramsregId), status, new Integer(orderNo));
    }
    else if ((status.equalsIgnoreCase("M")) && (orderNo.length() > 0))
    {
      RoadShowLogUtil.info("=== status === " + status + "=== for orderNo ===" + orderNo);
      flag = bsmims.update_PORTAL_TRANS_PHONE_ORDER_M(new Integer(paramsregId), status, new Integer(orderNo));
    }
    else if ((status.equalsIgnoreCase("H")) && (orderNo.length() > 0))
    {
      RoadShowLogUtil.info("=== status === " + status + "=== for orderNo ===" + orderNo);
      flag = bsmims.update_PORTAL_TRANS_PHONE_ORDER_M(new Integer(paramsregId), status, new Integer(orderNo));
    }
    else
    {
      RoadShowLogUtil.info("=== Nothing updated status === " + status + "=== for orderNo ===" + orderNo);
    }
    String home_page = "/SalesRoadshowCreateUpdate.jsp";

    this.log.info("============== End RoadShowSalesCreateConfirmServlet ================ ");

    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(home_page);
    dispatcher.forward(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}
