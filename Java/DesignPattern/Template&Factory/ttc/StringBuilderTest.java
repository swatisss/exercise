public class StringBuilderTest{
   public static void main(String[] args) {
      StringBuilder sb = new StringBuilder("123456789");
      sb.delete(0,3).delete(1,2).replace(2,4,"4");
      System.out.println(sb);

      StringBuilder sb1 = new StringBuilder("あいうえお");
      System.out.println(sb1.indexOf("あ"));
      System.out.println(sb1.indexOf("い"));
      System.out.println(sb1.indexOf("う"));
      System.out.println(sb1.indexOf("え"));
      System.out.println(sb1.indexOf("お"));

      sb1.replace(2,4,"お");
      System.out.println(sb1);
      System.out.println(sb1.indexOf("あ"));
   }
}
