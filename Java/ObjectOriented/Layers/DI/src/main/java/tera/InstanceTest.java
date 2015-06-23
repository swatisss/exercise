package tera;

public class InstanceTest{
   public static void main(String[] args) {
      Calculator cl = new IntegerCalculator();
      cl.plusString("45", "23");
      cl.plusString("10", "A");
   }
}
