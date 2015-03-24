import java.util.*;

class Sample5_18_4{
   public static void main(String[] args) {
      List<String> strs = Arrays.asList("Mercury", "Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune");

      strs.stream()
      .filter(str -> str.startsWith("M"))
      .forEach(str -> System.out.println(str));
   }
}
