package command;

import dao.AbstractDaoFactory;
import dao.ProductsDao;
import context.*;
import bean.Product;

public class AddProductCommand extends AbstractCommand{
   public ResponseContext execute(ResponseContext resc){
      RequestContext reqc =getRequestContext();

      String[] pids = reqc.getParameter("pid");
      String pid = pids[0];

      String[] names = reqc.getParameter("name");
      String name = names[0];

      String prices[] = reqc.getParameter("price");
      String price = prices[0];

      Product p = new Product();

      p.setPid(pid);
      p.setName(name);
      p.setPrice(price);

      AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
      ProductsDao dao = factory.getProductsDao();
      dao.addProduct(p);

      resc.setTarget("start");

      return resc;
   }
}
