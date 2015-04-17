import originalex.ZeroException;
import javax.servlet.ServletException;

public class NumberCheckLogic{
   public String judge(String number) throws ServletException{
      if(number.equals("0")){
         throw new ServletException(new ZeroException("0‚Å‚µ‚½"));
      }

      return number;
   }
}
