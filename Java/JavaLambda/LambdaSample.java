
import java.util.function.*;

/*@FunctionalInterface
interface Sample{
   void run(String name);
}
*/

class MyClass{
   static String generateGmailAddress(String account){
      return account+"@gmail.com";
   }

   public void generateYahooAddress(String account){
      System.out.println(account+"@yahoo.co.jp");
   }
}

public class LambdaSample {
   public static void main(String[] args) {
      Consumer<String> func = MyClass::generateGmailAddress;
      func.accept("blue210");
   }
}
