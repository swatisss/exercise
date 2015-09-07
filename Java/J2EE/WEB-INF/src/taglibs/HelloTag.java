package taglibs;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport{
   public int doStartTag() throws JspException{
      try{
         pageContext.getOut().println("<p>Hello</p>");

         JspWriter w = pageContext.getOut();

         pageContext.getOut().println("クラス名: "+w.getClass().getName());
      }catch(IOException e){
         throw new JspException(e);
      }
      return SKIP_BODY;
   }
}
