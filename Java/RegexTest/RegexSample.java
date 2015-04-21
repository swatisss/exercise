import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexSample{
   public static void main(String[] args) {
      // 正規表現を文字列として変数に格納する。
      String regex = "Blue\\d{3}";

      // 対象データ
      String text = "Blue210";

      // 正規表現をコンパイル
      Pattern pattern = Pattern.compile(regex);
      // Matcherオブジェクトの生成
      Matcher matcher = pattern.matcher(text);

      // マッチしているかどうかを判定
      if(matcher.matches()){
         System.out.println("マッチに成功！");
         System.out.println("マッチした文字列"+matcher.group());
      }else{
         System.out.println("マッチに失敗しました。");
      }
   }
}
