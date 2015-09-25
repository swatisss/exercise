package taglibs;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleHelloTag1 extends SimpleTagSupport{
   // 属性定義のためのプロパティ
   private String min;
   private String max;

   public String getMin(){
      return min;
   }

   public void setMin(String min){
      this.min = min;
   }

   public String getMax(){
      return max;
   }

   public void setMax(String max){
      this.max = max;
   }

   public void doTag() throws JspException, IOException{
      int minValue = Integer.parseInt(min);
      int maxValue = Integer.parseInt(max);

      for(int i = minValue; i <= maxValue; i++){
         // getJspContextは抽象クラスjavax.servlet.jsp.PageContextのサブクラスのインスタンスを返す
         // そのインスタンスからgetOut()で抽象クラスjavax.servlet.jsp.JspWriterのサブクラスのインスタンを取得
         getJspContext().getOut().println("<p>タグボディの内容「");

         // getJspBodyは抽象クラスjavax.servlet.jsp.tagext.JspFragmentのサブクラスのインスタンスを返す。
         // invokeで取得したタグボディを出力する
         getJspBody().invoke(null);

         getJspContext().getOut().println("J</p>");
      }
   }
}
