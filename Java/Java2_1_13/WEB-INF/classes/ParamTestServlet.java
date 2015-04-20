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
         // ServletConfig��getInitParameter()���\�b�h��web.xml��param-name���w�肵�Aparam-value�̒l���Q�b�g����B
         ServletConfig sc = getServletConfig();
         String encode = sc.getInitParameter("encode_type");
         String dformat = sc.getInitParameter("date_format");

         // �o�͂���R���e���c�̃^�C�v�ƕ����R�[�h�̎w��
         res.setContentType("text/html; charset="+encode);

         PrintWriter out = res.getWriter();

         out.println("<html>");
         out.println("<head>");
         out.println("<title>�������p�����[�^�e�X�g</title>");
         out.println("</head>");
         out.println("<body>");
         out.println("<h1>�A�N�Z�X����</h1>");

         // Calendar�I�u�W�F�N�g�̃C���X�^���X�𐶐�����B
         // �����Ȃ���Calendar.getInstance()�̓f�t�H���g�̃^�C���]�[������у��P�[�����g�p���ăJ�����_���擾
         Calendar cal = Calendar.getInstance();
         // ���t�̕\�����w�肷��
         SimpleDateFormat formatter = new SimpleDateFormat(dformat);
         String now = formatter.format(cal.getTime());

         out.println("�A�N�Z�X����: "+now);

         // �������p�����[�^�̖��O�����ׂĎ擾����B
         // �Ⴆ�΁A�������p�����[�^�̖��O��������Ȃ��Ƃ��Ɏg�p����B
         // getInitParameterNames()��Servlet�C���^�[�t�F�C�X�̃��\�b�h�BHttpServlet��Servlet�C���^�[�t�F�C�X����������GenericServlet�N���X���p�����Ă���B
         Enumeration names = getInitParameterNames();
         while(names.hasMoreElements()){
            // �߂�l��Object�Ȃ̂�String�ɃL���X�g����K�v������B
            String name = (String)names.nextElement();
            String value = getInitParameter(name);
            out.println("<p>"+name+"="+value+"</p>");
         }
         out.println("</body>");
         out.println("</html>");
      }
}
