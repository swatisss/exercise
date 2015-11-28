public class Client {
   public static void main(String[] args) {
      Logger success = new SuccessfulCompletionLogger();
      Logger error = new AbnormalTerminationLogger();
      Logger criticalError = new CriticalErrorLogger();

      // 処理させる順番の決定
      success.setLogger(error);
      error.setLogger(criticalError);

      // 0は正常終了、1がエラー、2が重大なエラー
      // 重大なエラーまでリクエストを回す
      success.handleRequest(2);

      // エラーまで
      success.handleRequest(1);

      // 正常終了した場合
      success.handleRequest(0);
   }
}

abstract class Logger{
   // 状態格納用の変数
   private int status;
   // 次の要求先
   protected Logger successor;

   // setter
   protected void setStatus(int status){
      this.status = status;
   }

   public void setLogger(Logger logger){
      this.successor = logger;
   }

   // クライアントが呼び出す固定されたメソッド
   public void handleRequest(int status){
      if(this.status == status){
         printoutLog();
      }else{
         successor.handleRequest(status);
      }
   }

   // サブクラスごとに変化させるリクエストに対する処理
   protected abstract void printoutLog();
}

class SuccessfulCompletionLogger extends Logger{
   public SuccessfulCompletionLogger(){
      setStatus(0);
   }

   protected void printoutLog(){
      System.out.println("正常終了しました。");
   }
}

class AbnormalTerminationLogger extends Logger{
   public AbnormalTerminationLogger(){
      setStatus(1);
   }

   protected void printoutLog(){
      System.out.println("エラーが発生しました。");
   }
}

class CriticalErrorLogger extends Logger{
   public CriticalErrorLogger(){
      setStatus(2);
   }

   protected void printoutLog(){
      System.out.println("重大なエラーが発生しました。");
   }
}
