package jdbc90;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class TransactionAggregator{
   public static void displayTable(String table){
      Connection conn= new OracleConnector("scott", "tiger").getConnection();
      TableReferer tr = new TableReferer(conn,table);
      String title = tr.getColumnName();
      System.out.println(title);
      ResultSet rs = tr.getTableContentsA();

      try{
         ResultSetMetaData rsmeta = rs.getMetaData();
         int columnCount = rsmeta.getColumnCount();

         while(rs.next()){
            String raw = "";
            for(int i = 1; i <= columnCount; i++){
               raw += rs.getString(i)+" ";
            }
            System.out.println(raw);
         }
      }catch(SQLException e){
         e.printStackTrace();
      }finally{
         try{
            conn.close();
         }catch(SQLException e){
            e.printStackTrace();
         }
      }
      System.out.println("接続終了");
   }
}
