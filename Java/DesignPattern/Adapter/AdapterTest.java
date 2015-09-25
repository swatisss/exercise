public class AdapterTest{
   public static void main(String[] args) {
      Adaptee ad = new Adaptee();

      Adapter adapter = new Adapter(ad);

      Client client = new Client();
      client.execute(adapter);
   }
}

class Client{
   public void execute(Target target){
      target.request();
   }
}

abstract class Target{
   public abstract void request();
}

class Adapter extends Target{
   private Adaptee adaptee;

   public Adapter(Adaptee adaptee){
      this.adaptee = adaptee;
   }

   public void request(){
      adaptee.specificRequest();
   }
}

class Adaptee {
   public void specificRequest(){
      System.out.println("Adapateeのメソッド");
   }
}
