
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendInquiry
 */
@WebServlet("/MailTest")
public class MailTest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        request.setCharacterEncoding("UTF-8");

        String title = request.getParameter("title");
        String message = request.getParameter("message");

        //System.out.println("タイトル：" + title);
        //System.out.println("メッセージ" + message);

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        try{
            Properties property = new Properties();
            
            //一般的なSMTPを使う場合

            //ポートが25の場合は省略可能
            property.put("mail.smtp.port", 25);

            Session session =
                    Session.getDefaultInstance(property, null);
            

            MimeMessage mimeMessage = new MimeMessage(session);

            InternetAddress toAddress =
                    new InternetAddress("blue210@example.com", "blue210");

            mimeMessage.setRecipient(Message.RecipientType.TO, toAddress);

            InternetAddress fromAddress =
                    new InternetAddress("blue210@example.com","blue210");

            mimeMessage.setFrom(fromAddress);

            mimeMessage.setSubject(title, "ISO-2022-JP");

            mimeMessage.setText(message, "ISO-2022-JP");

            Transport.send(mimeMessage);

            out.println("<htm><body>");
            out.println("■お問い合わせ内容を担当者へ送信しました。");
            out.println("<body></html>");
        }
        catch(Exception e){
            out.println("<html><body>");
            out.println("■担当者への送信に失敗しました");
            out.println("<br>エラーの内容" + e);
            out.println("</body></html>");
        }

        out.close();
    }

}
