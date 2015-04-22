import java.util.regex.Pattern;
import java.util.regex.Matcher;

class RegexSample2 {
   public static void main(String[] args) {
      // 正規表現文字列
      String regex = "[A-Z]\\w*";

      // 対象文字列
      String text = "If you want something you've never had, You have to do something you've never done.";

      // 正規表現をコンパイルする
      Pattern pattern = Pattern.compile(regex);
      // Matcherオブジェクト生成
      Matcher matcher = pattern.matcher(text);
      // マッチと結果の表示
      System.out.println("マッチした文字列");
      while(matcher.find()){
         System.out.println(" " + matcher.group());
      }
   }
}
