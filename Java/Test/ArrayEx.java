public class ArrayEx{
   public static void main(String[] args) {
      try{
         arry();
      }catch(RuntimeException e){
         System.out.println(e);
         e.getMessage();
         e.printStackTrace();
      }catch(Exception e){
         System.out.println(e);
      }
   }

   static void arry(){
      getRuntimeException();
   }

   static void getRuntimeException(){
      throw new RuntimeException("RuntimeException!");
   }
}
