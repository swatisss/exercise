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
         System.out.println("接続ｓ");
         conn.setAutoCommit(false);

         // resultSetType
         // TYPE_FORWARD_ONLY カーソル移動は前方方向のみ。他による更新を反映しない
         // TYPE_SCROLL_INSENSITIVE 前後にスクロール可能。他による更新を反映しない
         // TYPE_SCROLL_SENSITIVE 前後にスクロール可能。他による更新を反映

         // resultSetConcurrency
         // CONCUR_READ_ONLY カーソルを用いた更新・追加・削除を行わない。
         // CONCUR_UPDATABLE カーソルを用いた更新・追加・削除を行う
         stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

         String sql = "SELECT * FROM emp";

         rs = stm.executeQuery(sql);
         rs.first();
         System.out.println(rs.getString(1)+"\t"+rs.getString(2));
         while(rs.relative(2)){
            System.out.println(rs.getString(1)+"\t"+rs.getString(2));
         }
         /* 1行目から最終行までの出力を2回
         for(int i = 1; i <= 2; i++){
            while(rs.next()){
               System.out.println(rs.getString(1)+"\t"+rs.getString(2));
            }
            rs.beforeFirst();
            System.out.println("\n");
         }
         */

         /*　最終行から1行目までのデータを出力
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
