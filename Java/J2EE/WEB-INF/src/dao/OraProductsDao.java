package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Product;
import ep.ResourceAccessException;

public class OraProductsDao implements ProductsDao{
   public void addProduct(Product p){
      Connection cn = null;
      PreparedStatement pst = null;

      try{
         Class.forName("oracle.jdbc.driver.OracleDriver");

         cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");

         cn.setAutoCommit(false);

         String sql = "INSERT INTO t_products(pid,name,price)"+"VALUES(?,?,?)";

         pst = cn.prepareStatement(sql);

         pst.setString(1,p.getPid());
         pst.setString(2,p.getName());
         pst.setString(3,p.getPrice());

         pst.executeUpdate();

         cn.commit();
      }catch(ClassNotFoundException e){
         throw new ResourceAccessException(e.getMessage(),e);
      }catch(SQLException e){
         try{
            cn.rollback();
         }catch(SQLException e2){
            throw new ResourceAccessException(e2.getMessage(),e2);
         }

         throw new ResourceAccessException(e.getMessage(),e);
      }finally{
         try{
            if(pst != null){
               pst.close();
            }
         }catch(SQLException e2){
            throw new ResourceAccessException(e2.getMessage(),e2);
         }finally{
            try{
               if(cn != null){
                  cn.close();
               }
            }catch(SQLException e3){
               throw new ResourceAccessException(e3.getMessage(),e3);
            }
         }
      }
   }

   public Product getProduct(String pid){
      return null;
   }

   public  List getAllProducts(){
      Connection cn = null;
      ResultSet rs = null;
      PreparedStatement pst = null;

      ArrayList products = new ArrayList();

      try{
         Class.forName("oracle.jdbc.driver.OracleDriver");

         cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");

         cn.setAutoCommit(false);

         String sql = "SELECT pid, name,price from t_products";

         pst = cn.prepareStatement(sql);

         rs = pst.executeQuery();
         while(rs.next()){
            Product p = new Product();

            p.setPid(rs.getString(1));
            p.setName(rs.getString(2));
            p.setPrice(rs.getString(3));

            products.add(p);
         }
         cn.commit();
      }catch(ClassNotFoundException e){
         throw new ResourceAccessException(e.getMessage(),e);
      }catch(SQLException e){
         try{
            cn.rollback();
         }catch(SQLException e2){
            throw new ResourceAccessException(e2.getMessage(),e2);
         }

         throw new ResourceAccessException(e.getMessage(),e);
      }finally{
         try{
            if(rs != null){
               rs.close();
            }
            if(pst != null){
               pst.close();
            }
         }catch(SQLException e2){
            throw new ResourceAccessException(e2.getMessage(),e2);
         }finally{
            try{
               if(cn != null){
                  cn.close();
               }
            }catch(SQLException e3){
               throw new ResourceAccessException(e3.getMessage(),e3);
            }
         }
      }
      return products;
   }
}
