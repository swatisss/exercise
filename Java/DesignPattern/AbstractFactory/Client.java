import java.util.List;
import java.util.ArrayList;

public class Client{
   public void execute(String key){
      // ConcreteFactoryクラスの取得
      Env_Change_Factory factory = Env_Change_Factory.getFactory(key);

      // 問題検索クラスと解答提出クラスの取得
      FindQuestionsCommand  fqc = factory.createFindQuestions();
      SendAnswersCommand sac = factory.createSendAnswers();

      // メソッドを実行
      fqc.findQuestions();
      sac.sendAnswers();
   }
}
