package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class AuthenticateServlet extends HttpServlet{
  protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException{
      req.setCharacterEncoding("utf-8");

      String name = req.getParameter("name");
      String pass = req.getParameter("pass");

      if(name.equals("ica") && pass.equals("tera")){
        HttpSession session = req.getSession();
        session.setAttribute("token", "OK");
      }

      RequestDispatcher disp = req.getRequestDispatcher("/productinput");
      disp.forward(req, res);
    }
}
