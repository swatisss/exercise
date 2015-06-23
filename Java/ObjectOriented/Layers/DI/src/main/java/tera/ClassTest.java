package tera;

import java.util.List;

public class ClassTest{
   public static void main(String[] args) {
      List list = null;

      try{
         Class c = Class.forName("java.util.ArrayList");
         list = (List)c.newInstance();
      }catch(ClassNotFoundException e){
         e.printStackTrace();
      }catch(InstantiationException e){
         e.printStackTrace();
      }catch(IllegalAccessException e){
         e.printStackTrace();
      }

      list.add("test");
      list.add("ぶるー");

      System.out.println(list);
   }
}
