import java.util.function.*;

class MyClass{
            static boolean lengthCheck(String str){
      if(str.length() >= 10){
         return true;
      }
      return false;
   }
}

class Sample5_17_4{
   public static void main(String[] args) {
      String str = "’·‚¢’·‚¢’·‚¢’·‚¢•¶Žš—ñ";
      Predicate<String> func = MyClass::lengthCheck;
      System.out.println(func.test(str));
   }
}
