import java.util.*;
import java.util.stream.*;

class Sample5_18_1{
   public static void main(String[] args) {
      // Arrays.asList()は可変長引数からコレクションを生成する。
      List<Integer> numbers = Arrays.asList(86,75,64,100,90,86,46,86,59,92);

      // Streamの生成
      Stream<Integer> stream = numbers.stream();

      // 中間処理
      Stream<Integer> stream2 = stream.filter(number -> number >= 80);

      // 終端処理
      System.out.println(stream2.count());
   }
}
