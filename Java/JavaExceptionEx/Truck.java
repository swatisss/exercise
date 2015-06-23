class Car{
   // 親クラスで例外が送出されていないのに、子クラスでオーバーライドして例外を送出するようにはできない
   public void foo() /*throws Exception*/{
      System.out.println("parent");
   }
}

class Truck extends Car {
   public void foo() throws Exception{
      super.foo();
      System.out.println("child");
      throw new Exception();
   }

   public static void main(String[] args){
      try{
         new Truck().foo();
      }catch(Exception e){
         System.out.println("Exception");
      }
   }
}
