import java.util.function.*;

/*class MyClass{
   static Integer plus(Integer s){
      return s+1;
   }
}
*/

class Sample5_17_5{
   public static void main(String[] args) {
      Function<Integer, Integer> func = s -> s+1;
      System.out.println(func.apply(1));

   }
}
