import java.util.*;
import java.util.stream.*;

class Sample5_18_2{
   public static void main(String[] args) {
      // Arrays.asList()�͉ϒ���������R���N�V�����𐶐�����B
      List<Integer> numbers = Arrays.asList(86,75,64,100,90,86,46,86,59,92);
      // ���ԏ���
      long count =
      numbers.stream()
      // .filter(number -> number >= 80)
      .count();
      // �I�[����
      System.out.println(count);
   }
}
