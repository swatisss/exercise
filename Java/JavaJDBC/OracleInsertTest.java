import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

class OracleInsertTest{
   public static void main(String[] args) {
      try{
         // Driver�C���^�[�t�F�C�X�����������N���X�����[�h
         Class.forName("oracle.jdbc.driver.OracleDriver");

         // Connection�C���^�[�t�F�C�X����������N���X�̃C���X�^���X���Q�b�g
         Connection con = DriverManager.getConnection(
         "jdbc:oracle:thin:@localhost:1521:orcl",
         "scott",
         "tiger");

         // �����R�~�b�g��OFF�ɂ���B����L���B
         con.setAutoCommit(false);
         System.out.println("�ڑ�����");

         // SQL���̗p��
         String sql = "INSERT INTO emp(empno, ename) VALUES(9002,'OHARAZAWA')";

         // Statement�C���^�[�t�F�C�X����������N���X�̃C���X�^���X���擾�B
         Statement st = con.createStatement();

         // SQL���̎��s�B�g�����U�N�V�������J�n�����B
         // executeUpdate()���\�b�h�͖߂�l�Ƃ��ď�������������Ԃ��B
         int count = st.executeUpdate(sql);

         System.out.println(count+"������");

         // �g�����U�N�V�������R�~�b�g
         con.commit();

         // ���\�[�X�̊J���B�����ӂ�ƃ��b�N���J������Ȃ��ARDBMS�̐ڑ����ؒf����Ȃ��Ȃǂ̖�肪��������B
         // �X�e�[�g�����g���N���[�Y
         st.close();
         // RDBMS����ؒf
         con.close();
         System.out.println("�ؒf����");
      }catch(ClassNotFoundException e){
         e.printStackTrace();
      }catch(SQLException e){
         // rollback()����������Ȃ炱���B�������Arollback()���̂�SQLException���X���[����̂ŁAtry-catch���K�v�B
         e.printStackTrace();
      }
   }
}
