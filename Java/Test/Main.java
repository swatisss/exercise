import java.io.IOException;

public class Main{
   public static void main(String[] args) throws IOException{
      try{
      }catch(RuntimeException e){
         System.out.println(e);
      }
   }

   static void ex() throws IOException{
      if(Math.random() > 0.5)
         throw new IOException();
      throw new RuntimeException();
   }
}
