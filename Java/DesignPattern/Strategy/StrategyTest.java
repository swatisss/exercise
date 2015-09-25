
public class StrategyTest{
   public static void main(String[] args) {
      CalculationSupplier credit_cal = new CalculationSupplier();

      CalculationSupplier bank_cal = new CalculationSupplier();

      PaymentCalculator credit = new CreditPayment();
      PaymentCalculator bank = new BankPayment();

      credit_cal.setCalculator(credit);
      credit_cal.doCalculate(100000, 3);

      bank_cal.setCalculator(bank);
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
   public void calculate(int price, int period){
      int aggregate = price*1.09+300;
      System.out.println("商品価格: "+price+"支払い期間: "+period+"総支払額: "+aggregate);
   }
}

class BankPayment implements PaymentCalculator{
   public void calculate(int price, int period){
      int aggregate = price*1.07+500;
      System.out.println("商品価格: "+price+"支払い期間: "+period+"総支払額: "+aggregate);
   }
}
