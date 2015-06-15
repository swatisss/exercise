package tera;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
   public static void main(String[] args) {
      Properties prop = new Properties();

      try{
         prop.load(new FileInputStream("test.properties"));

         String value1 = prop.getProperty("language");
         String value2 = prop.getProperty("pattern");

         System.out.println(value1);
         System.out.println(value2);
      }catch(Exception e){
         e.printStackTrace();
      }
   }
}
