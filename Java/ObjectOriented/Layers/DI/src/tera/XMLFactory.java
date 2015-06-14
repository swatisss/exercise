package tera;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;

public class XMLFactory {
   private XMLFactory(){}

   public static Object load(String key){

      Object obj = null;

      try{
         Properties prop = new Properties();

         prop.loadFromXML(new FileInputStream("../../calc.xml"));

         String name = prop.getProperty(key);

         Class c = Class.forName(name);

         obj = c.newInstance();
      }catch(ClassNotFoundException e){
         e.printStackTrace();
      }catch(IOException e){
         e.printStackTrace();
      }catch(InstantiationException e){
         e.printStackTrace();
      }catch(IllegalAccessException e){
         e.printStackTrace();
      }
      return obj;
   }
}
