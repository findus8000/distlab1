package bo;

import ui.ProductInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ProductHandler {
    public static Collection<ProductInfo> getAllProducts() {
        Collection c = Product.getAllProducts();
        ArrayList<ProductInfo> products = new ArrayList<ProductInfo>();
        for(Iterator i = c.iterator(); i.hasNext();) {
            Product p = (Product) i.next();
            products.add(new ProductInfo(p.getProductID(), p.getProductName(), p.getPrice(), p.getStockQuantity(), p.getCategoryID()));
        }
        return products;
    }
}
