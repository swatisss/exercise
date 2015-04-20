import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Enumeration;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class ParamTestServlet extends HttpServlet{
   public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException{
         // ServletConfigのgetInitParameter()メソッドでweb.xmlのparam-nameを指定し、param-valueの値をゲットする。
         ServletConfig sc = getServletConfig();
         String encode = sc.getInitParameter("encode_type");
         String dformat = sc.getInitParameter("date_format");

         // 出力するコンテンツのタイプと文字コードの指定
         res.setContentType("text/html; charset="+encode);

         PrintWriter out = res.getWriter();

         out.println("<html>");
         out.println("<head>");
         out.println("<title>初期化パラメータテスト</title>");
         out.println("</head>");
         out.println("<body>");
         out.println("<h1>アクセス日時</h1>");

         // Calendarオブジェクトのインスタンスを生成する。
         // 引数なしのCalendar.getInstance()はデフォルトのタイムゾーンおよびロケールを使用してカレンダを取得
         Calendar cal = Calendar.getInstance();
         // 日付の表示を指定する
         SimpleDateFormat formatter = new SimpleDateFormat(dformat);
         String now = formatter.format(cal.getTime());

         out.println("アクセス日時: "+now);

         // 初期化パラメータの名前をすべて取得する。
         // 例えば、初期化パラメータの名前が分からないときに使用する。
         // getInitParameterNames()はServletインターフェイスのメソッド。HttpServletはServletインターフェイスを実装したGenericServletクラスを継承している。
         Enumeration names = getInitParameterNames();
         while(names.hasMoreElements()){
            // 戻り値がObjectなのでStringにキャストする必要がある。
            String name = (String)names.nextElement();
            String value = getInitParameter(name);
            out.println("<p>"+name+"="+value+"</p>");
         }
         out.println("</body>");
         out.println("</html>");
      }
}
