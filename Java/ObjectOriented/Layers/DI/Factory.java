// プロパティファイルを利用してインスタンス化を行なう

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Factory{
   public static void main(String[] args) {
      Object obj = null;

      try{
         Properties prop = new Properties();

         prop.load(new FileInputStream("test.properties"));

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
