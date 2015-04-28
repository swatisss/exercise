/*
context 振る舞い
problem メソッドの引数に対して、デフォルト値をどのように設定するか。
solution　引数の組み合わせに応じてオーバーロードしたメソッドを作成し、引数の少ないメソッドから多いメソッドへ処理を以上する。
*/

class DefaultParameterMethod {
   public static void main(String[] args) {
      Calculator cl = new Calculator();
      System.out.println("値段と税率両方を渡した場合 "+cl.getPrice(1000, 1.08));
      System.out.println("値段だけが渡された場合 "+ cl.getPrice(1000));
      System.out.println("なにも渡されなかった場合 "+cl.getPrice());
   }
}

class Calculator{
   public int getPrice(int price, double tax){
      // 計算処理はすべてここに集中できる。
      return (int)(price * tax);
   }

   public int getPrice(int price){
      return this.getPrice(price, 1.05);
   }

   public int getPrice(){
      return this.getPrice(0,0);
   }
}
