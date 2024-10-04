package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Vector;

public class ProductDB extends bo.Product{

    public static Collection getAllProductsFromDB() {
        Vector v = new Vector();
        try {
            Connection c = DBManager.getConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Product");

            while (rs.next()) {
                int id = rs.getInt("ProductID");
                String name = rs.getString("ProductName");
                int price = rs.getInt("Price");
                int stock = rs.getInt("StockQuantity");
                int categoryID = rs.getInt("CategoryID");
                v.addElement(new ProductDB(id,name,price,stock,categoryID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return v;
    }

    private ProductDB(int productID, String productName, int price, int stockQuantity, int categoryID) {
        super(productID, productName, price, stockQuantity, categoryID);
    }
}
