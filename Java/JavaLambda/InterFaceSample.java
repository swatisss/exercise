interface MyIf{
   int num = 10;
   /* JavaSE8�̐V�@�\�@interface�ɃN���X���\�b�h���`
   static void show(){
      System.out.println("�C���^�[�t�F�C�X�̃N���X���\�b�h");
   };

   // �C���X�^���X���\�b�h���`
   default void func(){
      System.out.println("�C���^�[�t�F�C�X�̃C���X�^���X���\�b�h");
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
