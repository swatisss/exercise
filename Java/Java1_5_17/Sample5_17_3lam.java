import java.util.function.*;

/*class MyClass{
   static Integer strCount(String str){
      return str.length();
   }
}*/

class Sample5_17_3{
   public static void main(String[] args) {
      String str = "abcde";
      // 引数String、戻り値Integer型の関数型インターフェイス
      Function<String, Integer> func = strl -> str.length();
      System.out.println(func.apply(str));
   }
}
