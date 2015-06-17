package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import bean.BookBean;
import bean.CartBean;

public class SessionStartServlet extends HttpServlet{
   public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException,ServletException{
         // javax.servlet.http.HttpSessionインターフェイスの実装クラスのインスタンスを取得
         // すでにsessionがあれば、既存のものが取得されない場合は新しくsessionが開始される。
         // sessionはHTTPに関連しているので、HttpServletRequestから取得する。
         HttpSession session = req.getSession();

         CartBean cart = (CartBean)session.getAttribute("cart");

         if(cart == null){
            cart = new CartBean();
         }

         BookBean book1 = new BookBean();
         book1.setId("1");
         book1.setTitle("Java入門");
         book1.setPrice("2500");

         cart.addBook(book1);

         session.setAttribute("cart", cart);

         RequestDispatcher dispatcher = req.getRequestDispatcher("cartinfo");

         dispatcher.forward(req, res);
      }
}
