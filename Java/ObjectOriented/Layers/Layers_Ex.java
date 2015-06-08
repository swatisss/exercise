
interface Calculator{
   int plusString(String args1, String args2);
}

class IntegerCalculator implements Calculator{
   private Accessor ac = null;

   public IntegerCalculator(){
      this.ac = new FileAccessor();
   }

   @Override
   public int plusString(String args1, String args2){
      int intArgs1 = Integer.parseInt(args1);
      int intArgs2 = Integer.parseInt(args2);
      int result = intArgs1 + intArgs2;

      ac.writeLog(Integer.toString(result));

      return result;
   }
}

interface Accessor{
   void writeLog(String log);
}

class FileAccessor implements Accessor{
   @Override
   public void writeLog(String log){
      System.out.println(log);
   }
}
