import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

class OracleInsertTest{
   public static void main(String[] args) {
      Connection con = null;
      Statement st = null;
      try{
         // Driver�C���^�[�t�F�C�X�����������N���X�����[�h
         Class.forName("oracle.jdbc.driver.OracleDriver");

         // Connection�C���^�[�t�F�C�X����������N���X�̃C���X�^���X���Q�b�g
         con = DriverManager.getConnection(
         "jdbc:oracle:thin:@localhost:1521:orcl",
         "scott",
         "tiger");

         // �����R�~�b�g��OFF�ɂ���B����L���B
         con.setAutoCommit(false);
         System.out.println("�ڑ�����");

         // SQL���̗p��
         String sql = "INSERT INTO emp(empno, ename) VALUES(9004,'�Ԃ�[')";

         // Statement�C���^�[�t�F�C�X����������N���X�̃C���X�^���X���擾�B
         st = con.createStatement();

         // SQL���̎��s�B�g�����U�N�V�������J�n�����B
         // executeUpdate()���\�b�h�͖߂�l�Ƃ��ď�������������Ԃ��B
         int count = st.executeUpdate(sql);

         System.out.println(count+"������");

         // �g�����U�N�V�������R�~�b�g
         con.commit();
      }catch(ClassNotFoundException e){
         e.printStackTrace();
      }catch(SQLException e){
         e.printStackTrace();
         if(con != null && st != null){
            try{
               con.rollback();
               System.out.println("���[���o�b�N����");
            }catch(SQLException ex){
               ex.printStackTrace();
            }
         }
      }finally{
         try{
            if(st != null){
               st.close();
            }

            if(con != null){
               con.close();
            }
            System.out.println("���\�[�X�̉��");
         }catch(SQLException e){
            e.printStackTrace();
         }
      }
   }
}
