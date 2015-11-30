package command;
import dao.AbstractDaoFactory;
import dao.ProductsDao;
import context.*;
import java.util.List;

public class GetProductsCommand extends AbstractCommand{
   public ResponseContext execute(ResponseContext resc){
      AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
      ProductsDao dao = factory.getProductsDao();

      List products = dao.getAllProducts();

      resc.setResult(products);

      resc.setTarget("view");

      return resc;
   }
}
