import java.util.*;
import java.util.stream.*;

class Sample5_18_1{
   public static void main(String[] args) {
      // Arrays.asList()�͉ϒ���������R���N�V�����𐶐�����B
      List<Integer> numbers = Arrays.asList(86,75,64,100,90,86,46,86,59,92);

      // Stream�̐���
      Stream<Integer> stream = numbers.stream();

      // ���ԏ���
      Stream<Integer> stream2 = stream.filter(number -> number >= 80);

      // �I�[����
      System.out.println(stream2.count());
   }
}
