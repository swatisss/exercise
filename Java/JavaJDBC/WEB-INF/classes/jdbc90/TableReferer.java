package jdbc90;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TableReferer{
   Connection conn = null;
   Statement stm = null;
   ResultSet rs = null;

   public TableReferer(Connection conn, String tablename){
      this.conn = conn;
      String query = "SELECT * FROM "+tablename;
      try{
         stm = conn.createStatement();
         rs = stm.executeQuery(query);
      }catch(SQLException e){
         e.printStackTrace();
      }
   }

   public String getColumnName(){
      String columnName = "";

      try{
         ResultSetMetaData rsmeta = rs.getMetaData();
         int columnCount = rsmeta.getColumnCount();

         for(int i = 1; i <= columnCount; i++){
            columnName += rsmeta.getColumnName(i)+" ";
         }
      }catch(SQLException e){
         e.printStackTrace();
      }
      return columnName;
   }

   public ArrayList getColumnNameList(){
      ArrayList al = new ArrayList();
      try{
         ResultSetMetaData rsmeta = rs.getMetaData();
         int columnCount = rsmeta.getColumnCount();
         for(int i = 1; i <= columnCount; i++){
            al.add(rsmeta.getColumnName(i));
         }
      }catch(SQLException e){
         e.printStackTrace();
      }
      return al;
   }

   public ResultSet getTableContentsA(){
      return rs;
   }
}
