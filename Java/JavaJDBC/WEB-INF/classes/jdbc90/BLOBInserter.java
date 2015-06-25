package jdbc90;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BLOBInserter{
   private Connection cn = null;
   private PreparedStatement st = null;
   private FileInputStream fip = null;

   public void insertBlob(String filename){
      try{
         cn = new OracleConnector("scott","tiger").getConnection();
         cn.setAutoCommit(false);

         File file = new File(filename);
         fip = new FileInputStream(file);

         st = cn.prepareStatement("insert into blob_data_demo values(?,?)");

         st.setInt(1,100);

         st.setBinaryStream(2,fip,(int)file.length());
         st.executeUpdate();
         cn.commit();
      }catch(IOException ie){
         ie.printStackTrace();

         if(cn != null && st != null){
            try{
               cn.rollback();
            }catch(SQLException e){
               e.printStackTrace();
            }
         }
      }catch(SQLException se){
         se.printStackTrace();

         if(cn != null && st != null){
            try{
               cn.rollback();
            }catch(SQLException e){
               e.printStackTrace();
            }
         }
      }finally{
         try{
            if(st != null){
               st.close();
            }
         }catch(SQLException e){
            e.printStackTrace();
         }finally{
            try{
               if(fip != null){
                  fip.close();
               }
            }catch(IOException e){
               e.printStackTrace();
            }finally{
               try{
                  if(cn != null){
                     OracleConnector.closeConnection(cn);
                  }
               }catch(SQLException ex){
                  ex.printStackTrace();
               }
            }
         }
      }
   }
}
