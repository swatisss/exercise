/*
context 振る舞い
problem　複数のコンストラクタがある場合、コンストラクタの引数をどのようにインスタンス変数に設定するか
solution　privateなsetメソッドを利用して、コンストラクタの引数をインスタンス変数に設定する。
*/

class ConstructorParameterMethod {
   public static void main(String[] args) {
      Student st = new Student("ぶるー", 26);
      Student st2 = new Student("加賀", 26);
      st.showProfile();
      st2.showProfile();
   }
}

class Student {
   private String name;
   private int age;

   Student(String name, int age){
      set(name,age);
   }

   Student(String name){
      set(name,0);
   }

   // インスタンス変数への格納処理をこのメソッドに集中させることができる。
   // 処理を変更する場合でも、この内部の処理を変更するだけでよい。
   protected void set(String name, int age){
      this.name = name;
      this.age = age;
   }

   public void showProfile(){
      System.out.println(name + "\t" + age);
   }
}
