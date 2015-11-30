package dao;

import java.util.List;
import bean.Product;

public interface ProductsDao{
   void addProduct(Product p);
   Product getProduct(String pid);
   List getAllProducts();
}
