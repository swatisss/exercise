package tera;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DatabaseMetaData;

class DBMetaTest{
   public static void main(String[] args) {
      Connection conn = null;
      Statement stm = null;
      ResultSet rs = null;

      try{
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SCOTT","tiger");
         System.out.println("接続");

         DatabaseMetaData dbMeta = conn.getMetaData();
         String dbName = dbMeta.getDatabaseProductName();

         String[] types = {"TABLE"};

         ResultSet dbInfo = dbMeta.getTables(null,"SCOTT", null, types);

         while(dbInfo.next()){
            String tableCatalog = dbInfo.getString(1);
            System.out.println(tableCatalog);

            String tableSchem = dbInfo.getString(2);
            System.out.println(tableSchem);

            String typeName = dbInfo.getString(4);
            System.out.println(typeName);

            System.out.println("--------------------------");
         }
      }catch(ClassNotFoundException e){
         e.printStackTrace();
      }catch(SQLException e){
         e.printStackTrace();
         if(conn != null && stm != null){
            try{
               conn.rollback();
               System.out.println("ロールバック完了");
            }catch(SQLException ex){
               ex.printStackTrace();
            }
         }
      }finally{
         try{
            if(stm != null){
               stm.close();
            }

            if(conn != null){
               conn.close();
            }
            System.out.println("リソースの解放");
         }catch(SQLException e){
            e.printStackTrace();
         }
      }
   }
}
