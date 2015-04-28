
class DefaultValueMethod {
   public static void main(String[] args) {
      Student st = new Student();
      // set‚µ‚Ä‚©‚ç•\¦
      st.setAge(26);
      System.out.println(st.getAge());

      // getDedaultAge()‚ğg‚Á‚½ê‡
      Student st2 = new Student();
      System.out.println(st2.getAge());
   }
}

class Student {
   private int age = -1;

   public void setAge(int age){
      this.age = age;
   }

   public int getAge(){
      if(this.age == -1){
         this.age = getDefaultAge();
      }
      return this.age;
   }

   public int getDefaultAge(){
      return 40;
   }
}
