import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class SendSelect{
   public static void main(String[] args) {
      try{
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");

         System.out.println("ê⁄ë±äÆóπ");
         conn.setAutoCommit(false);

         String sql = "SELECT empno, ename FROM emp";

         Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

         ResultSet rs = stm.executeQuery(sql);

         rs.next();
         String empno = rs.getString(1);
         String ename = rs.getString(2);

         System.out.println("empno = "+ empno);
         System.out.println("ename = "+ ename);

         while(rs.relative(2)){
            empno = rs.getString(1);
            ename = rs.getString(2);

            System.out.println("empno = "+ empno);
            System.out.println("ename = "+ ename);
         }

         rs.close();
         stm.close();
         conn.close();
         System.out.println("êÿífäÆóπ");
      }catch(ClassNotFoundException e){
         e.printStackTrace();
      }catch(SQLException e){
         e.printStackTrace();
      }
   }
}
