/*
context �U�镑��
problem�@�����̃R���X�g���N�^������ꍇ�A�R���X�g���N�^�̈������ǂ̂悤�ɃC���X�^���X�ϐ��ɐݒ肷�邩
solution�@private��set���\�b�h�𗘗p���āA�R���X�g���N�^�̈������C���X�^���X�ϐ��ɐݒ肷��B
*/

class ConstructorParameterMethod {
   public static void main(String[] args) {
      Student st = new Student("�Ԃ�[", 26);
      Student st2 = new Student("����", 26);
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

   // �C���X�^���X�ϐ��ւ̊i�[���������̃��\�b�h�ɏW�������邱�Ƃ��ł���B
   // ������ύX����ꍇ�ł��A���̓����̏�����ύX���邾���ł悢�B
   protected void set(String name, int age){
      this.name = name;
      this.age = age;
   }

   public void showProfile(){
      System.out.println(name + "\t" + age);
   }
}
