public class SendAnswers_Prod implements SendAnswersCommand{
   @Override
   public void sendAnswers(){
      System.out.println("解答を送りました。from 本番環境");
   }
}
