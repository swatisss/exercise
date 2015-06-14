package tera;
// プロパティファイルを利用してインスタンス化を行なう

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Factory{
   private Factory(){}

   public static Object load(String key){
      Object obj = null;

      try{
         Properties prop = new Properties();

         prop.load(new FileInputStream("/Users/blue210/GitHub/exercise/Java/ObjectOriented/Layers/DI/calc.properties"));

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
