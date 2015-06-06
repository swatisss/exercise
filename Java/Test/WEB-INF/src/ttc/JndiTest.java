package ttc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.sql.InitialContext;
import javax.sql.NamingException;

import bean.CustomerBean;

public class CustomerDao{
   public void saveCustomer(CustomerBean suctomer){
      Conenction conn = null;
      Statement stm = null;

      try{
         InitialContext inic = new InitialContext();

         DataSource source = (DataSource)inic.lookup("java:comp/env/jdbc/ora");

         conn = source.getConnection();

         stm = conn.createStatement();
      }catch(NamingException e){
         e.printStackTrace();
      }catch(SQLException e){
         e.printStackTrace();
      }finally{
         try{
            if(stm != null){
               stm.close();
            }
         }catch(SQLException e){
            e.printStackTrace();
         }finally{
            try{
               if(conn != null){
                  conn.close();
               }
            }catch(SQLException e){
               e.printStackTrace();
            }
         }
      }
   }
}
