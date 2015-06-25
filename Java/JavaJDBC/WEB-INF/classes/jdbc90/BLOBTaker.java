package jdbc90;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BLOBTaker{
   public void takeBlobFile(){
      Connection cn = null;
      PreparedStatement st = null;
      ResultSet rs = null;
      FileOutputStream output = null;

      try{
         cn = new OracleConnector("scott","tiger").getConnection();
         cn.setAutoCommit(false);

         st = cn.prepareStatement("select b_lob from blob_data_demo where bno=?");
         st.setInt(1,100);
         rs = st.executeQuery();
         rs.next();

         File file = new File("C:\\Users\\koyama\\Pictures\\snapshot-1284687325.221586.jpg");
         output = new FileOutputStream(file);

         Blob blob = rs.getBlob(1);

         BufferedInputStream binput = new BufferedInputStream(blob.getBinaryStream());

         byte[] buff = new byte[4*1024];

         while(true){
            int size = binput.read(buff,0,buff.length);

            if(size == -1)break;

            output.write(buff,0,size);
         }

         binput.close();
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
            if(output != null){
               output.close();
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
