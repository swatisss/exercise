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
      System.out.println("驕句多繧貞・繧企幕縺蹴PG");
   }
}

class GameB implements Games{
   public void play(){
      System.out.println("繧｢繧､繝峨Ν繧偵・繝ｭ繝・Η繝ｼ繧ｹ縺吶ｋ繧ｷ繝･繝溘Ξ繝ｼ繧ｷ繝ｧ繝ｳ繧ｲ繝ｼ繝");
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
      System.out.println("驥代↓迚ｩ險繧上○繧騎PG");
   }

   private void getCharacterByPayment(){
      System.out.println("驥代〒莠ｺ繧定ｲｷ縺・PG");
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
      System.out.println("繧ｨ繝翫ラ繝ｪ雋ｷ縺｣縺｡繧・＞縺ｾ縺励◆");
   }

   private void getStoryByPayment(){
      System.out.println("繝ｩ繝悶せ繝医・繝ｪ縺ｯ遯∫┯縺ｫ・郁ｪｲ驥托ｼ・);
   }
}
