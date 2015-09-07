public class FindQuestions_Prod implements FindQuestionsCommand{
   @Override
   public void findQuestions(){
      System.out.println("問題を探します。from 本番環境");
   }
}
