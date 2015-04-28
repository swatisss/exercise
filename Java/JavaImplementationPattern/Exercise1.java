
class Exercise1{
   public static void main(String[] args) {
      Student s1 = new Student("suzuki", 100);
      Student s2 = new Student("tanaka");

      if(s1.getPoint() == -1){
         System.out.println(s1.getName()+": �e�X�g���󌱂��Ă��܂���B");
      }else{
         System.out.println(s1.getName()+":"+s1.getPoint());
      }

      if(s2.getPoint() == -1){
         System.out.println(s2.getName()+": �e�X�g���󌱂��Ă��܂���B");
      }else{
         System.out.println(s2.getName()+":"+s2.getPoint());
      }
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

   // Constructor Parameter Method�̓K�p
   private void set(String name, int point){
      this.name = name;
      this.point = point;
   }

   // Default Value Method�̓K�p
   public String getName(){
      return this.name;
   }

   public int getPoint(){
      return this.point;
   }

   public int getDefaultPoint(){
      return -1;
   }
}
