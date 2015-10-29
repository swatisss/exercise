package servlet;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontServlet extends HttpServlet{
   public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException{
         doPost(req, res);
      }


   public void doPost(HttpServletRequest req, HttpServletResponse res)
      throws IOException,ServletException{
         req.setCharacterEncoding("utf-8");

         Map data = req.getParameterMap();

         String path = req.getServletPath();
         AbstractCommand command = CommandFactory1.getCommand(path);

         command.init(data);

         String url = command.execute();

         Object result = command.getResult();
         req.setAttribute("result",result);

         RequestDispatcher dispatcher = req.getRequestDispatcher(url);
         dispatcher.forward(req, res);
      }
}
