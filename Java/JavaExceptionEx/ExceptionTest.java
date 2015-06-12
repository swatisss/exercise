public class ExceptionTest{
   public static void main(String[] args) throws Exception{
      ex1();
   }

   private static void ex1() throws Exception{
      ex2();
   }

   private static void ex2() throws Exception{
         throw new Exception();
   }
}
