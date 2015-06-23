package jdbc90;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReferServlet extends HttpServlet{
   public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException{
         req.setCharacterEncoding("utf-8");

         String table = req.getParameter("table");
         System.out.println(table);

         Connection conn = null;
         Statement stm = null;
         ArrayList oal = new ArrayList();

         conn = new OracleConnector("scott","tiger").getConnection();
         TableReferer tr = new TableReferer(conn, table);
         oal.add(tr.getColumnNameList());

         ResultSet rs = tr.getTableContentsA();

         try{
            ResultSetMetaData rsmeta = rs.getMetaData();
            int columnCount = rsmeta.getColumnCount();
            while(rs.next()){
               ArrayList ial = new ArrayList();
               for(int i = 1; i <= columnCount; i++){
                  ial.add(rs.getString(i));
               }
               oal.add(ial);
            }
            req.setAttribute("list", oal);
         }catch(SQLException e){
            throw new ServletException(e);
         }finally{
            if(stm != null){
               try{
                  stm.close();
               }catch(SQLException e){

               }
            }

            if(conn != null){
               try{
                  conn.close();
               }catch(SQLException e){

               }
            }
         }
         req.getRequestDispatcher("result").forward(req, res);
      }
}
