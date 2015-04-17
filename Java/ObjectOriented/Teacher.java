public class PasiriTest{
   public static void main(String[] args) {
      Teacher ta = new Teacher();
      ta.call()
   }
}

class Teacher{
   public static void main(String[] args) {
      ErrandPerson ep1 = new GoodErrand();
      ErrandPerson ep2 = new NormalErrand();
      ErrandPerson ep3 = new BadErrand();

      ep1.buy(1000);
      ep2.buy(1000);
      ep3.buy(1000);
   }
}

interface ErrandPerson{
   public abstract void buy(int money);
}

class GoodErrand implements ErrandPerson{
   public void buy(int money){
      System.out.println("先生の好きなおにぎり");
   }
}

class NormalErrand implements ErrandPerson{
   public void buy(int money){
      System.out.println("おにぎり");
   }
}

class BadErrand implements ErrandPerson{
   public void buy(int money){
      System.out.println("サンドイッチ");
   }
}
