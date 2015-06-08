public class StringUtils{
   public static String toSnakeCase(String text){
      if(text == null) throw new NullPointerException("text == null.");

      String snake = text;

      Pattern p = Pattern.compile(snake);
      for(;;){
         Matcher m = p.matcher(snake);
         if(!m.find()) break;
         snake = m.replaceFirst("_" + m.group(1).toLowerCase());
      }
      return snake.replaceFirst("^_","");
   }
}
