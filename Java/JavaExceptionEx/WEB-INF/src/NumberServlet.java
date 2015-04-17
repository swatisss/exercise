import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import originalex.ZeroException;

public class NumberServlet extends HttpServlet{
   public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException{
         req.setCharacterEncoding("Windows-31J");

         String str = req.getParameter("number");

         String number = "";
         try{
            NumberCheckLogic ncl = new NumberCheckLogic();
            number = ncl.judge(str);
         }catch(ZeroException e){
            throw new ServletException(new ZeroException("0‚¾‚æ"));
         }

         res.setContentType("text/html; Windows-31J");
         req.setAttribute("number", number);

         RequestDispatcher dispatch = req.getRequestDispatcher("/result");
         dispatch.forward(req, res);
      }
}
