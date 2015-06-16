package bean;

import java.io.Serializable;

public class BookBean implements Serializable{
   private String id;
   private String title;
   private String price;

   public BookBean(){}

   public void setId(String id){
      this.id = id;
   }

   public void setTitle(String title){
      this.title = title;
   }

   public void setPrice(String price){
      this.price = price;
   }

   public String getId(){
      return id;
   }

   public String getTitle(){
      return title;
   }

   public String getPrice(){
      return price;
   }
}
