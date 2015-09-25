package taglibs;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class HelloTag5 extends BodyTagSupport{
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

   public int doStartTag() throws JspException{
      try{
         pageContext.getOut().println("<p>Start</p>");

         // JspWriter w = pageContext.getOut();

         // pageContext.getOut().println("クラス名: "+w.getClass().getName());
      }catch(IOException e){
         throw new JspException(e);
      }
      return EVAL_BODY_BUFFERED;
   }

   public int doAfterBody() throws JspException{
      try{
         String content = bodyContent.getString();

         int minValue = Integer.parseInt(min);
         int maxValue = Integer.parseInt(max);

         for(int i = minValue; i <= maxValue; i++){
            getPreviousOut().println("<p>タグボディの内容「"+content+"」</p>");
         }
      }catch(IOException e){
         throw new JspException(e);
      }
      return SKIP_BODY;
   }
   public int doEndTag() throws JspException{
      try{
         pageContext.getOut().println("<p>END</p>");
      }catch(IOException e){
         throw new JspException(e);
      }
      return  EVAL_PAGE;
   }
}
