import java.util.*;

class Sample5_18_3{
   public static void main(String[] args) {
      List<Integer> sales = Arrays.asList(16,17,12,3,12,8,5,1,9,11,5,12);
      Optional<Integer> first =
      sales.stream()
      .sorted()
      .findFirst();

      System.out.println(first.get());
   }
}
