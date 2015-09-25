
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class FrontServlet extends HttpServlet{
   public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException{
         System.out.println("てすと");
         doPost(req, res);
   }

  public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException{
      String pathInfo = req.getPathInfo();
      System.out.println(pathInfo);
      String url = "/WEB-INF/jsp"+pathInfo+".jsp";

      System.out.println(url);

      RequestDispatcher disp = req.getRequestDispatcher(url);
      disp.forward(req, res);
    }
}
