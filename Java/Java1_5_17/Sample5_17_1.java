@FunctionalInterface
interface MyFunctionalInterface{
   public String run(String str);
}

class MyClass{
   static String generateGmailAddress(String account){
      return account+"@gmail.com";
   }
   static String generateYmailAddress(String account){
      return account+"@yahoo.co.jp";
   }
}

class Sample5_17_1{
   public static void main(String[] args) {
      MyFunctionalInterface func = MyClass::generateYmailAddress;

      String account = func.run("ubukata");
      System.out.println(account);
   }
}
