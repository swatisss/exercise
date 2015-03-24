interface MyIf{
   int num = 10;
   /* JavaSE8の新機能　interfaceにクラスメソッドを定義
   static void show(){
      System.out.println("インターフェイスのクラスメソッド");
   };

   // インスタンスメソッドを定義
   default void func(){
      System.out.println("インターフェイスのインスタンスメソッド");
   }

   void func2();
   */
   void func3();
}

class A implements MyIf{
   // static int num = 0;
   int num = 20;
   public void func3(){
      System.out.println(MyIf.num);
   }
   // public void func3(){}
}

class InterFaceSample{
   public static void main(String[] args) {
      MyIf mf = new A();
      mf.func3();
   }
}
