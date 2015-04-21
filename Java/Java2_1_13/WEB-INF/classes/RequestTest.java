import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestTest extends HttpServlet{
   public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException{
         // Classオブジェクトを取得する
         Class myClass = req.getClass();
         // Classオブジェクトの名前を取得
         String className = myClass.getName();

         res.setContentType("text/html; charset=Windows-31J");

         // HttpResponseオブジェクトからPrintWriterを取得
         PrintWriter out = res.getWriter();

         out.println("<html>");
         out.println("<head>");
         out.println("<title>要求テスト</title>");
         out.println("</head>");
         out.println("<body>");
         out.println("<h1>要求テスト</h1>");

         out.println("reqに格納されたインスタンスのクラス名ーーーーー<br>");
         out.println("reqのクラス名="+className+"<br><br>");

         out.println("ServletRequestのメソッドーーーーー<br>");
         out.println("メッセージボディのタイプ="+req.getContentType()+"<br>");
         out.println("メッセージボディのサイズ="+req.getContentLength()+"<br>");
         out.println("プロトコル="+req.getProtocol()+"<br>");
         out.println("クライアントのIP="+req.getRemoteAddr()+"<br>");
         out.println("クライアントのホスト名"+req.getRemoteHost()+"<br><br>");

         out.println("HttpServletRequestのメソッドーーーーー<br>");
         out.println("ブラウザの情報="+req.getHeader("user-agent")+"<br>");
         out.println("リファラ="+req.getHeader("referer")+"<br>");
         out.println("メソッド名="+req.getMethod()+"<br>");
         out.println("コンテキストパス="+req.getContextPath()+"<br>");
         out.println("サーブレットパス="+req.getServletPath()+"<br>");
         out.println("パス情報="+req.getPathInfo()+"<br>");
         out.println("リクエスト行に含まれるURI="+req.getRequestURI()+"<br>");
         out.println("URL全体="+req.getRequestURL()+"<br>");
         out.println("</body>");
         out.println("</html>");
   }
}
