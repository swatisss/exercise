import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import bean.CustomerBean;
import ttc.JndiTest;

public class UserRegisterServlet extends HttpServlet{

  // ユーザーが入力したユーザ名とパスワードを受け取って, 確認画面に送る
   public void doGet(HttpServletRequest req, HttpServeltResponse res)
      throws IOException,ServletException{
         req.setCharacterEncoding("utf-8");

         String name = req.getParameter("name");
         String age = req.getParameter("age");

         CustomerBean
         res.setContentType("text/html; charset=utf-8");

         req.setAttribute("name", name);
         req.setAttribute("age", age);

         RequestDispathcer dispatcher = req.getRequestDispatcher("");
         dispathcer.forward(req, res);
   }

   // ユーザーが確認した入力情報を受け取って,データベースに登録する処理へ送る
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws IOException, ServletException{
            req.setCharacterEncoding("utf-8");

            String name = req.getParameter("name");
            String age = req.getParameter("age");

            res.setContentType("text/html;charset=utf-8");

            req.setAttribute("name", name);
            req.setAttribute("age", age);

            RequestDispatcher dispath = req.getRequestDispatcher("r");
            dispath.forward(req, res);
        }
}
