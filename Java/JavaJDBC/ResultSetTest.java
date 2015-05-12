import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class ResultSetTest {
   public static void main(String[] args) {
      Connection conn = null;
      Statement stm = null;
      ResultSet rs = null;

      try{
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
         System.out.println("�ڑ���");
         conn.setAutoCommit(false);

         // resultSetType
         // TYPE_FORWARD_ONLY �J�[�\���ړ��͑O�������̂݁B���ɂ��X�V�𔽉f���Ȃ�
         // TYPE_SCROLL_INSENSITIVE �O��ɃX�N���[���\�B���ɂ��X�V�𔽉f���Ȃ�
         // TYPE_SCROLL_SENSITIVE �O��ɃX�N���[���\�B���ɂ��X�V�𔽉f

         // resultSetConcurrency
         // CONCUR_READ_ONLY �J�[�\����p�����X�V�E�ǉ��E�폜���s��Ȃ��B
         // CONCUR_UPDATABLE �J�[�\����p�����X�V�E�ǉ��E�폜���s��
         stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

         String sql = "SELECT * FROM emp";

         rs = stm.executeQuery(sql);
         rs.first();
         System.out.println(rs.getString(1)+"\t"+rs.getString(2));
         while(rs.relative(2)){
            System.out.println(rs.getString(1)+"\t"+rs.getString(2));
         }
         /* 1�s�ڂ���ŏI�s�܂ł̏o�͂�2��
         for(int i = 1; i <= 2; i++){
            while(rs.next()){
               System.out.println(rs.getString(1)+"\t"+rs.getString(2));
            }
            rs.beforeFirst();
            System.out.println("\n");
         }
         */

         /*�@�ŏI�s����1�s�ڂ܂ł̃f�[�^���o��
         rs.afterLast();
         while(rs.previous()){
            System.out.println(rs.getString(1)+"\t"+rs.getString(2));
         }*/

      }catch(ClassNotFoundException e){
         e.printStackTrace();
      }catch(SQLException e){
         e.printStackTrace();
      }finally{
         try{
            if(rs != null)
               rs.close();
            if(stm != null)
               stm.close();
            if(conn != null)
               conn.close();
         }catch(SQLException ex){
            ex.printStackTrace();
         }
      }
   }
}
