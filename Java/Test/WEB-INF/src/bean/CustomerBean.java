package bean;

import java.io.Serializable;

public class CustomerBean implements Serializable{
   private String name = "";
   private String age = "";

   public void setName(String name){
      this.str1 = name;
   }

   public void setAge(String age){
      this.age = age;
   }

   public String getName(){
      return name;
   }

   public String getAge(){
      return age;
   }
}
