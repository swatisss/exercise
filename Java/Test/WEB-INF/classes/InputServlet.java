
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;


public class InputServlet extends HttpServlet{

    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws IOException, ServletException{
            req.setCharacterEncoding("Windows-31J");

            String name = req.getParameter("name");
            String pass = req.getParameter("pass");

            res.setContentType("text/html;charset=Windows-31J");

            req.setAttribute("name", name);
            req.setAttribute("pass", pass);

            RequestDispatcher dispath = req.getRequestDispatcher("/result");
            dispath.forward(req, res);
        }
}
