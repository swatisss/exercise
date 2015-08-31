import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FrontServlet extends HttpServlet{
   public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException{

      req.setAttribute("test1", new String("data1"));

      HttpSession session = req.getSession();
      session.setAttribute("test2", new String("data2"));

      ServletContext context = getServletContext();
      context.setAttribute("test3", new String("data3"));

      RequestDispatcher disp = req.getRequestDispatcher("/elobject");
      disp.forward(req, res);
   }
}
