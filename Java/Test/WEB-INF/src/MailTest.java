
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

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        try{
            Properties property = new Properties();

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
            out.println("テスト成功！");
            out.println("<body></html>");
        }
        catch(Exception e){
            out.println("<html><body>");
            out.println("テスト失敗....");
            out.println("test"+e);
            out.println("</body></html>");
        }

        out.close();
    }

}
