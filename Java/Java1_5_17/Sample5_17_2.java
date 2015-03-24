import java.util.function.*;

class MyClass{
   static void generateGmailAddress(String account){
      System.out.println(account+"@gmail.com");
   }
   static void generateYmailAddress(String account){
      System.out.println(account+"@yahoo.co.jp");
   }
}

class Sample5_17_2{
   public static void main(String[] args) {
      Consumer<String> func = MyClass::generateGmailAddress;
      func.accept("ubukata");
   }
}
