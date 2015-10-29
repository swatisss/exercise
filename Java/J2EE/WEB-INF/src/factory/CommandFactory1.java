package factory;

import command.AbstractCommand;

public abstract class CommandFactory1 {
   public static AbstractCommand getCommand(String path){
      AbstractCommand command = null;

      // substring(int beginIndex)は指定したindexから文字列の最後までを取得する
      String nonSlashPath = path.substring(1);
      // 先頭一文字の取得　substring(int beginIndex, int endIndex)で指定したindexの文字列を返す
      String firstChar = nonSlashPath.substring(0,1);
      // 先頭一文字を大文字にして取得
      String firstUpperChar = firstChar.toUpperCase();
      // 先頭を大文字にしてクラス名にする
      String name = firstUpperChar+nonSlashPath.substring(1)+"Command";

      try{
         Class c = Class.forName(name);
         command = (AbstractCommand)c.newInstance();
      }catch(ClassNotFoundException e){
         throw new RuntimeException(e.getMessage(),e);
      }catch(InstantiationException e){
         throw new RuntimeException(e.getMessage(),e);
      }catch(IllegalAccessException e){
         throw new RuntimeException(e.getMessage(),e);
      }
      return command;
   }
}
