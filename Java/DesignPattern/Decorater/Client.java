public class Client{
	public Abstraction m_Abstraction;

   public static void main(String[] args) {
      PaymentSystem gameA = new GameAPaymentSystem(new GameA());
      PaymentSystem gameB = new GameBPaymentSystem(new GameB());

      gameA.play();
      gameB.play();
   }
}

interface Games{
   void play();
}

class GameA implements Games{
   public void play(){
      System.out.println("ιε½γεEγιγRPG");
   }
}

class GameB implements Games{
   public void play(){
      System.out.println("γ’γ€γγ«γγEγ­γE₯γΌγΉγγγ·γ₯γγ¬γΌγ·γ§γ³γ²γΌγ ");
   }
}

abstract class PaymentSystem implements Games{
   private Games games;

   public PaymentSystem(Games games){
      this.games = games;
   }

   public Games getGames(){
      return this.games;
   }
}

class GameAPaymentSystem extends PaymentSystem{
   public GameAPaymentSystem(Games games){
      super(games);
   }

   public void play(){
      getGames().play();
      getItemByPayment();
      getCharacterByPayment();
   }

   private void getItemByPayment(){
      System.out.println("ιγ«η©θ¨γγγRPG");
   }

   private void getCharacterByPayment(){
      System.out.println("ιγ§δΊΊγθ²·γEPG");
   }
}

class GameBPaymentSystem extends PaymentSystem{
   public GameBPaymentSystem(Games games){
      super(games);
   }

   public void play(){
      getGames().play();
      getItemByPayment();
      getStoryByPayment();
   }

   private void getItemByPayment(){
      System.out.println("γ¨γγγͺθ²·γ£γ‘γEγΎγγ");
   }

   private void getStoryByPayment(){
      System.out.println("γ©γγΉγγEγͺγ―ηͺηΆγ«Eθͺ²ιοΌE);
   }
}
