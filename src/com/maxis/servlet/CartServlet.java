package com.maxis.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maxis.store.Cart;

public class CartServlet
  extends HttpServlet
{
  public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws IOException
  {
    Enumeration headers = req.getHeaderNames();
    while (headers.hasMoreElements())
    {
      String header = (String)headers.nextElement();
      System.out.println(header + ": " + req.getHeader(header));
    }
    Cart cart = getCartFromSession(req);

    String action = req.getParameter("action");
    String item = req.getParameter("item");
    if ((action != null) && (item != null)) {
      if ("add".equals(action)) {
        cart.addItem(item);
      } else if ("remove".equals(action)) {
        cart.removeItems(item);
      }
    }
    String cartXml = cart.toXml();
    res.setContentType("text/xml");
    res.getWriter().write(cartXml);
  }

  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException
  {
    doPost(req, res);
  }

  private Cart getCartFromSession(HttpServletRequest req)
  {
    HttpSession session = req.getSession(true);
    Cart cart = (Cart)session.getAttribute("cart");
    if (cart == null)
    {
      cart = new Cart();
      session.setAttribute("cart", cart);
    }
    return cart;
  }
}