import java.util.ArrayList;

public class Test{
   public static void main(String[] args) {
      X x1 = new X();
      try{
         x1.aaa();
      }catch(InCastException e){
         e.printStackTrace();
         e.getMessage();
      }
   }
}

class A{}
class B extends A{}

class X{
   public void aaa() throws InCastException{
      try{
         A a = new A();
         B b = (B)a;
         /*Object ojt = "例外";
         System.out.println((Integer)ojt);*/
         /*ArrayList al = new ArrayList();
         al.add(1);
         System.out.println((String)al.get(0));*/
      }catch(ClassCastException e){
         throw new InCastException("クラスキャスト例外です。",e);
      }
   }
}
class InCastException extends Exception{
   public InCastException(String message, Throwable cause){
      super(message,cause);
   }
}
