

class ComposedMethod {
   public static void main(String[] args) {
      Calculator cl = new Calculator();
      System.out.println(cl.getTaxedPrice(1000, 0));
      System.out.println(cl.getTaxedPrice(1000, 1));
      System.out.println(cl.getTaxedPrice(1000, 2));
   }
}

class Calculator {
   private static final int JAPAN = 0;
   private static final int USA = 1;
   private static final int GERMANY = 2;

   public int getTaxedPrice(int price, int country){
      double tax = getTax(country);

      return (int)(price+(price * tax));
   }

   public double getTax(int country){
      double tax = 0.0;

      if(country == JAPAN){
         tax = 0.08;
      }

      if(country == USA){
         tax = 0.10;
      }

      if(country == GERMANY){
         tax = 0.15;
      }

      return tax;
   }
}
