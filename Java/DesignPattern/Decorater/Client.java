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
      System.out.println("運命を�Eり開くRPG");
   }
}

class GameB implements Games{
   public void play(){
      System.out.println("アイドルを�EロチE��ースするシュミレーションゲーム");
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
      System.out.println("金に物言わせるRPG");
   }

   private void getCharacterByPayment(){
      System.out.println("金で人を買ぁEPG");
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
      System.out.println("エナドリ買っちめE��ました");
   }

   private void getStoryByPayment(){
      System.out.println("ラブスト�Eリは突然に�E�課金！E);
   }
}
