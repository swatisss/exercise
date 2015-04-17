import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javqx.servlet.RequestDispatcher;

import bean.Bean;


public class TwoServlet extends HttpServlet{
   public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException{
         req.setCharacterEncoding("UTF-8");

         String str1 = req.getParameter("str1");
         String str2 = req.getParameter("str2");

         Bean bean = new Bean();
         bean.setStr1(str1);
         bean.setStr2(str2);

         res.setContentType("text/html; charset=Windows-31J");
         req.setAttribute("bean", bean);

         RequestDispatcher dis = req.getRequestDispatcher("/result");
         dis.forward(req, res);
      }
}
