import java.util.function.*;

/*class MyClass{
   static Integer strCount(String str){
      return str.length();
   }
}*/

class Sample5_17_3{
   public static void main(String[] args) {
      String str = "abcde";
      // ����String�A�߂�lInteger�^�̊֐��^�C���^�[�t�F�C�X
      Function<String, Integer> func = strl -> str.length();
      System.out.println(func.apply(str));
   }
}
