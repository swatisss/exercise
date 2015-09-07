public class Test_Env_Factory extends Env_Change_Factory{
   public FindQuestionsCommand createFindQuestions(){
      return new FindQuestions_Prod();
   }

   public SendAnswersCommand createSendAnswers(){
      return new SendAnswers_Prod();
   }
}
