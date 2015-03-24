import java.util.stream.*;

class Sample5_18_6{
   public static void main(String[] args) {
      int sum = IntStream.rangeClosed(0, 10)
      .map(n -> n*2)
      .sum();

      System.out.println(sum);
   }
}
