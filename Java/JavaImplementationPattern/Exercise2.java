
class Exercise2{
   public static void main(String[] args) {
      Student s1 = new Student("suzuki", 100);
      Student s2 = new Student("tanaka");
      s1.getTestDetail();
      s2.getTestDetail();
   }
}

class Student{
   private String name;
   private int point = this.getDefaultPoint();

   Student(String name, int point){
      this.set(name,point);
   }

   Student(String name){
      this.set(name, this.getDefaultPoint());
   }

   // Constructor Parameter Methodの適用
   private void set(String name, int point){
      this.name = name;
      this.point = point;
   }

   // Default Value Methodの適用
   public String getName(){
      return this.name;
   }

   public int getPoint(){
      return this.point;
   }

   public int getDefaultPoint(){
      return -1;
   }

   //ComposedMethodの適用
   public void getTestDetail(){
      if(this.getPoint() == -1){
         System.out.println(this.getName()+": テストを受験していません。");
      }else{
         System.out.println(this.getName()+":"+this.getPoint());
      }
   }
}
