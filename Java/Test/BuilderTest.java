class BuilderTest{
   public static void main(String[] args) {
      String size = " Large";
      int number = 3;

      StringBuilder sb = new StringBuilder();
      /*sb.append(number+size+" apples, please!");
      System.out.println(sb);*/

      sb.append(number).append(size).append(" apples, please!");
      System.out.println(sb);

      // 指定した範囲の文字列を削除するdelete()メソッド
      sb.delete(0,sb.length());
      System.out.println(sb);
   }
}
