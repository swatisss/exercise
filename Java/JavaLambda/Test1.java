/* ジェネリクスを用いたクラス定義
* class クラス名<型変数名>{
*   // クラス内で型変数が利用できる
* }
* 型変数には一般的にTypeのTやElementのEが使われる。
*/

// 複数指定もできる
class Str<T, U>{
   private T str;
   private U value;

   public Str(T t, U u){
      this.str = t;
      this.value = u;
   }

   public T getStr(){
      return this.str;
   }

   public U getValue(){
      return this.value;
   }
}

public class Test1{
   public static void main(String[] args) {
      Str<String, String> s1 = new Str<>("ぶるー","加賀さん");
      System.out.println(s1.getStr());
      System.out.println(s1.getValue());

      Str<Integer, String> s2 = new Str<>(1234, "ぶるー");
      System.out.println(s2.getStr());
      System.out.println(s2.getValue());
   }
}
