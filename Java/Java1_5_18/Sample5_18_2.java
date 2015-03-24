import java.util.*;
import java.util.stream.*;

class Sample5_18_2{
   public static void main(String[] args) {
      // Arrays.asList()は可変長引数からコレクションを生成する。
      List<Integer> numbers = Arrays.asList(86,75,64,100,90,86,46,86,59,92);
      // 中間処理
      long count =
      numbers.stream()
      // .filter(number -> number >= 80)
      .count();
      // 終端処理
      System.out.println(count);
   }
}
