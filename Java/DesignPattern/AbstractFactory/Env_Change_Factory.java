import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Properties;

public abstract class Env_Change_Factory {
   public abstract FindQuestionsCommand createFindQuestions();
   public abstract SendAnswersCommand createSendAnswers();

   public static Env_Change_Factory getFactory(String key){
      Env_Change_Factory factory = null;
      Properties prop = new Properties();

      try{
         prop.load(new FileInputStream("factory.properties"));

         String factoryName = prop.getProperty(key);

         Class c = Class.forName(factoryName);

         factory = (Env_Change_Factory)c.newInstance();

      }catch(FileNotFoundException e){
         throw new RuntimeException(e.getMessage(), e);
      }catch(IOException e){
         throw new RuntimeException(e.getMessage(), e);
      }catch(ClassNotFoundException e){
         throw new RuntimeException(e.getMessage(), e);
      }catch(InstantiationException e){
         throw new RuntimeException(e.getMessage(), e);
      }catch(IllegalAccessException e){
         throw new RuntimeException(e.getMessage(), e);
      }
      return factory;
   }
}
