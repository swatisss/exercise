package tera;

public class IntegerCalculator implements Calculator{
   private Accessor ac;

   public IntegerCalculator(){
      ac = (Accessor)Factory.load("accessor");

   }

   public int plusString(String xStr, String yStr){
      int x = 0;
      int y = 0;

      try{
         x = Integer.parseInt(xStr);
         y = Integer.parseInt(yStr);
      }catch(NumberFormatException e){
         e.printStackTrace();
         throw new IllegalArgumentException("数値として解釈できません");
      }

      int ret = x+y;

      try{
         ac.writeLog(x+"+"+y+"="+ret);
      }catch(Exception e){
         e.printStackTrace();
      }

      return ret;
   }
}
