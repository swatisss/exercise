import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestTest extends HttpServlet{
   public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException{
         // Class�I�u�W�F�N�g���擾����
         Class myClass = req.getClass();
         // Class�I�u�W�F�N�g�̖��O���擾
         String className = myClass.getName();

         res.setContentType("text/html; charset=Windows-31J");

         // HttpResponse�I�u�W�F�N�g����PrintWriter���擾
         PrintWriter out = res.getWriter();

         out.println("<html>");
         out.println("<head>");
         out.println("<title>�v���e�X�g</title>");
         out.println("</head>");
         out.println("<body>");
         out.println("<h1>�v���e�X�g</h1>");

         out.println("req�Ɋi�[���ꂽ�C���X�^���X�̃N���X���[�[�[�[�[<br>");
         out.println("req�̃N���X��="+className+"<br><br>");

         out.println("ServletRequest�̃��\�b�h�[�[�[�[�[<br>");
         out.println("���b�Z�[�W�{�f�B�̃^�C�v="+req.getContentType()+"<br>");
         out.println("���b�Z�[�W�{�f�B�̃T�C�Y="+req.getContentLength()+"<br>");
         out.println("�v���g�R��="+req.getProtocol()+"<br>");
         out.println("�N���C�A���g��IP="+req.getRemoteAddr()+"<br>");
         out.println("�N���C�A���g�̃z�X�g��"+req.getRemoteHost()+"<br><br>");

         out.println("HttpServletRequest�̃��\�b�h�[�[�[�[�[<br>");
         out.println("�u���E�U�̏��="+req.getHeader("user-agent")+"<br>");
         out.println("���t�@��="+req.getHeader("referer")+"<br>");
         out.println("���\�b�h��="+req.getMethod()+"<br>");
         out.println("�R���e�L�X�g�p�X="+req.getContextPath()+"<br>");
         out.println("�T�[�u���b�g�p�X="+req.getServletPath()+"<br>");
         out.println("�p�X���="+req.getPathInfo()+"<br>");
         out.println("���N�G�X�g�s�Ɋ܂܂��URI="+req.getRequestURI()+"<br>");
         out.println("URL�S��="+req.getRequestURL()+"<br>");
         out.println("</body>");
         out.println("</html>");
   }
}
