import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import bean.Bean;

public class GetServlet extends HttpServlet{
   public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException{
      req.setCharacterEncoding("Windows-31J");

      String str1 = req.getParameter("str1");
      String str2 = req.getParameter("str2");

      Bean bean = new Bean();
      bean.setStr1(str1);
      bean.setStr2(str2);

      res.setContentType("text/html; Windows-31J");
      req.setAttribute("bean",bean);
      RequestDispatcher dipatch = req.getRequestDispatcher("/result2");
      dipatch.forward(req, res);
   }
}
