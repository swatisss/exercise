import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexSample{
   public static void main(String[] args) {
      // ���K�\���𕶎���Ƃ��ĕϐ��Ɋi�[����B
      String regex = "Blue\\d{3}";

      // �Ώۃf�[�^
      String text = "Blue210";

      // ���K�\�����R���p�C��
      Pattern pattern = Pattern.compile(regex);
      // Matcher�I�u�W�F�N�g�̐���
      Matcher matcher = pattern.matcher(text);

      // �}�b�`���Ă��邩�ǂ����𔻒�
      if(matcher.matches()){
         System.out.println("�}�b�`�ɐ����I");
         System.out.println("�}�b�`����������"+matcher.group());
      }else{
         System.out.println("�}�b�`�Ɏ��s���܂����B");
      }
   }
}
