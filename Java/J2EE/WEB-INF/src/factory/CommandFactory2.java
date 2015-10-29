package factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import command.AbstractCommand;

public abstract class CommandFactory2 {
   public static AbstractCommand getCommand(String path){
      AbstractCommand command = null;
      Properties prop = new Properties();

      try{
         prop.load(new FileInputStream("commands.Properties"));
         String name = prop.getProperty(path);
         Class c = Class.forName(name);
         command = (AbstractCommand)c.newInstance();
      }catch(FileNotFoundException e){
         throw new RuntimeException(e.getMessage(),e);
      }catch(IOException e){
         throw new RuntimeException(e.getMessage(),e);
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
