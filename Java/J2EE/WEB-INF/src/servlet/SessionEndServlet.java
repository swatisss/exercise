package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class SessionEndServlet extends HttpServlet{
   public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException,ServletException{

         HttpSession session = req.getSession();

         session.invalidate();

         RequestDispatcher dispatcher = req.getRequestDispatcher("cartinfo");

         dispatcher.forward(req, res);
      }
}
