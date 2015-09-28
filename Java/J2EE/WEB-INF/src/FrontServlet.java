
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
         doPost(req, res);
   }

  public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException{
      String pathInfo = req.getPathInfo();
      String path2 = pathInfo.replace("/","");
      System.out.println("replaceしてみた　"+path2);
      String url = "WEB-INF/jsp/order"+path2+".jsp";

      System.out.println(url);

      RequestDispatcher disp = req.getRequestDispatcher(url);
      disp.forward(req, res);
    }
}
