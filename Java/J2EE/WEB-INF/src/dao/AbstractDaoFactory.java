package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public abstract class AbstractDaoFactory{
   public static AbstractDaoFactory getFactory(){
      AbstractDaoFactory factory = null;
      Properties prop = new Properties();

      try{
         prop.load(new FileInputStream("C:\\GitHub\\exercise\\Java\\J2EE\\dao.properties"));

         String name = prop.getProperty("dao");

         Class c = Class.forName(name);
         factory = (AbstractDaoFactory)c.newInstance();
      }catch(FileNotFoundException e){
         throw new RuntimeException(e.getMessage(),e);
      }catch(IOException e){
         throw new RuntimeException(e.getMessage(),e);
      }catch(ClassNotFoundException e){
         throw new RuntimeException(e.getMessage(),e);
      }catch(InstantiationException e){
         throw new RuntimeException(e.getMessage(),e);
      }catch(IllegalAccessException e){
         throw new RuntimeException(e.getMessage(),e);
      }
      return factory;
   }

   public abstract ProductsDao getProductsDao();
}
