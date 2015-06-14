package tera;

interface Accessor{
   void writeLog(String log);
}

public class FileAccessor implements Accessor{
   public void writeLog(String log){
      System.out.println(log);
   }
}
