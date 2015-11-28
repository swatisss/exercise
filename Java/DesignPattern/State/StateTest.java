
public class StateTest{
   public static void main(String[] args) {
      CalculationSupplier credit_cal = new CalculationSupplier();

      CalculationSupplier bank_cal = new CalculationSupplier();

      credit_cal.setCalculator(CreditPayment.getInstance());
      credit_cal.doCalculate(100000, 3);

      bank_cal.setCalculator(BankPayment.getInstance());
      bank_cal.doCalculate(200000, 5);
   }
}

class CalculationSupplier{
   private PaymentCalculator calculator = null;

   public void setCalculator(PaymentCalculator calculator){
      this.calculator = calculator;
   }

   public void doCalculate(int price, int period){
      calculator.calculate(price, period);
   }
}

interface PaymentCalculator{
   void calculate(int price, int period);
}

class CreditPayment implements PaymentCalculator{
   private static PaymentCalculator uniqueInstance = null;

   private CreditPayment(){}

   public static PaymentCalculator getInstance(){
      if(uniqueInstance == null){
         uniqueInstance = new CreditPayment();
      }
      return uniqueInstance;
   }

   public void calculate(int price, int period){
      int aggregate = (int)(price*1.09+300);
      System.out.println("商品価格: "+price+"　支払い期間: "+period+"　総支払額: "+aggregate);
   }
}

class BankPayment implements PaymentCalculator{
   private static PaymentCalculator uniqueInstance = null;

   private BankPayment(){}

   public static PaymentCalculator getInstance(){
      if(uniqueInstance == null){
         uniqueInstance = new BankPayment();
      }
      return uniqueInstance;
   }

   public void calculate(int price, int period){
      int aggregate = (int)(price*1.07+500);
      System.out.println("商品価格: "+price+"　支払い期間: "+period+"　総支払額: "+aggregate);
   }
}
