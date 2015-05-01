import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.ResultSet;

public class CallableStatementDemo{
   public static void main(String[] args) {
      Connection con = null;
      Statement st = null;
      try{
         // Driverインターフェイスを実装したクラスをロード
         Class.forName("oracle.jdbc.driver.OracleDriver");

         // Connectionインターフェイスを実装するクラスのインスタンスをゲット
         con = DriverManager.getConnection(
         "jdbc:oracle:thin:@localhost:1521:orcl",
         "scott",
         "tiger");

         // 自動コミットをOFFにする。毎回記入。
         con.setAutoCommit(false);
         System.out.println("接続完了");

         CallableStatement cstm = con.prepareCall("{call insert_emp()}");

         cstm.execute();

         Statement stm = con.createStatement();
         ResultSet rs = stm.executeQuery("SELECT * FROM emp");
         
         while(rs.next()){
            int empno = rs.getInt(1);
            String ename = rs.getString(2);
            String job = rs.getString(3);
            int mgr = rs.getInt(4);
            String hiredate = rs.getString(5);
            int sal = rs.getInt(6);
            int comm = rs.getInt(7);
            int deptno = rs.getInt(8);
            System.out.println(empno+"："+ename+"："+job+""+mgr+"："+hiredate+"："+sal+"："+comm+"："+deptno);
         }

         rs.close();
         stm.close();
         con.close();
         }catch(ClassNotFoundException e){
            e.printStackTrace();
         }catch(SQLException e){
            e.printStackTrace();
            if(con != null && st != null){
               try{
                  con.rollback();
                  System.out.println("ロールバック完了");
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
            System.out.println("リソースの解放");
         }catch(SQLException e){
            e.printStackTrace();
         }
      }
   }
}
