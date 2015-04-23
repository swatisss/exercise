import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CheckTest extends HttpServlet{
   public void doPost(HttpServletRequest req, HttpServletResponse res)
      throws IOException,ServletException{
         req.setCharacterEncoding("Windows-31J");

         String user = req.getParameter("user");
         String pass = req.getParameter("pass");

         res.sendRedirect("404");
         
         PrintWriter out = res.getWriter();
         out.println("<html>");
         out.println("<head>");
         out.println("<title>結果</title>");
         out.println("</head>");
         out.println("<body>");
         out.println("<h1>入力データ取得テスト</h1>");
         out.println("<p>入力されたユーザ名は"+user+"</p>");
         out.println("<p>パスワードは"+pass+"</p>");
         out.println("</body>");
         out.println("</html>");


      }
}
