import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class JDBCTraining {
   private Connection conn = null;

   public void getConnection(){
      try{
         Class.forName("oracle.jdbc.driver.OracleDriver");

         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
         System.out.println("ê⁄ë±");

         conn.setAutoCommit(false);

      }catch(ClassNotFoundException e){
         System.out.println(e.getMessage());
      }catch(SQLException e){
         System.out.println(e.getMessage());
      }catch(Exception e){
         System.out.println(e.getMessage());
      }
   }

   public void executeSQL(String sql){
      try{
         this.getConnection();
         Statement stm = conn.createStatement();

         int count = stm.executeUpdate(sql);
         System.out.println(count+"åèèàóùÇµÇ‹ÇµÇΩÅB");
         conn.commit();
      }catch(SQLException e){
         e.printStackTrace();
      }
   }

   public void selectAllData(){
      try{
         String select = "SELECT * FROM emp";
         Statement stm = conn.createStatement();

         ResultSet rs = stm.executeQuery(select);

         while(rs.next()){
            System.out.println("empno = "+rs.getString(1)+"\t"+"ename = "+rs.getString(2));
         }

         rs.close();
         stm.close();
         this.closeConnection();
      }catch(SQLException e){
         e.printStackTrace();
      }
   }


   public void closeConnection(){
      try{
         conn.close();
         System.out.println("êÿífÇµÇ‹ÇµÇΩÅB");
      }catch(SQLException e){
         e.printStackTrace();
      }
   }
}
