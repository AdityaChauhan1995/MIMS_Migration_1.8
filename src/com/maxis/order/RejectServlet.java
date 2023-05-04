package com.maxis.order;

import com.maxis.log.RejectLogUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RejectServlet
  extends HttpServlet
{
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    try
    {
      int len = request.getContentLength();
      byte[] input = new byte[len];

      ServletInputStream sin = request.getInputStream();
      int count = 0;
      int c;
      while ((c = sin.read(input, count, input.length - count)) != -1) {
        count += c;
      }
      sin.close();

      String inString = new String(input);

      RejectLogUtil.info("======= RejectServlet STAGING inString ======= " + inString);

      StringTokenizer st = new StringTokenizer(inString, "|");
      List list = new Vector();
      while (st.hasMoreElements())
      {
        String token = st.nextElement().toString();
        RejectLogUtil.info("token = " + token);
        list.add(token);
      }
      String orderId = (String)list.get(0);
    }
    catch (IOException e)
    {
      try
      {
        response.setStatus(400);
        response.getWriter().print(e.getMessage());
        response.getWriter().close();
      }
      catch (IOException ioe)
      {
        ioe.getMessage();
      }
    }
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doPost(request, response);
  }
}
