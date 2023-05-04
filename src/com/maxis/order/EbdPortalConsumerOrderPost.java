package com.maxis.order;

import com.maxis.constant.Constant;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;

public class EbdPortalConsumerOrderPost
  extends HttpServlet
{
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    System.out.println("======= POST POST EbdPortalConsumerOrderPost POST POST ======= ");

    HttpClient client = new HttpClient();
    boolean status = true;


    PostMethod method = new PostMethod(Constant.HIT_URL);
    method.addParameter("param1", "hari");
    method.addParameter("param2", "babu");

    List<NameValuePair> parameters = new ArrayList();
    parameters.add(new BasicNameValuePair("param1", "hari"));
    parameters.add(new BasicNameValuePair("param2", "babu"));

    String s = URLEncodedUtils.format(parameters, "UTF-8");
    StringEntity entity = new StringEntity(s, "UTF-8");
    entity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
    List<NameValuePair> result = URLEncodedUtils.parse(entity);


    method.getParams().setParameter("http.method.retry-handler", new DefaultHttpMethodRetryHandler());
    method.setQueryString(s);
    try
    {
      int statusCode = client.executeMethod(method);
      System.out.println("====== Method Executed ======= : " + statusCode);
      System.out.println("====== Method URL method.getStatusLine() ======= : " + method.getStatusLine());
      System.out.println("====== Method URL method.getStatusText() ======= : " + method.getStatusText());
      System.out.println("====== Method URL method.getURI() ======= : " + method.getURI());
      System.out.println("====== Method URL method.getResponseBodyAsString() ======= : " + method.getResponseBodyAsString());
      System.out.println("====== Method URL method.getQueryString() ======= : " + method.getQueryString());
      if (statusCode != 200)
      {
        System.err.println("===== URL HIT NOT OK ===== " + method.getStatusLine());
        status = false;
      }
      else
      {
        System.err.println("===== URL HIT OK ===== ");

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
        out.println("<font color=blue>Statusline : </font>" + method.getStatusLine() + "<br>");
        out.println("<font color=blue>StatusText : </font>" + method.getStatusText() + "<br>");
        out.println("<font color=blue>URI Hit : </font>" + method.getURI() + "<br>");

        String queryString = "param1";
        out.println("<font color=gray>Parameter in URL </font><br>");
        if (queryString != null)
        {
          out.println("<font color=gray>Query String from URL</font>");
          out.println(" ===>     { <font color=blue>" + HTMLFilter.filter(method.getQueryString()) + "</font> } <br>");
        }
        else
        {
          out.println("No Parameters from URL");
        }
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
      }
    }
    catch (HttpException e)
    {
      System.err.println("=========== Fatal protocol violation: ========== " + e.getMessage());
      e.printStackTrace();
      status = false;
    }
    catch (IOException e)
    {
      System.err.println("========= Fatal transport error 'IOException': ========= " + e.getMessage());
      e.printStackTrace();
      status = false;
    }
    finally
    {
      method.releaseConnection();
    }
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doPost(request, response);
  }
}
