package bo;

import db.ProductDB;

import java.util.Collection;

public class Product {
    private int ProductID;
    private String ProductName;
    private int Price;
    private int StockQuantity;
    private int CategoryID;

    static public Collection getAllProducts() {
        return ProductDB.getAllProductsFromDB();
    }

    protected Product(int productID, String productName, int price, int stockQuantity, int categoryID) {
        ProductID = productID;
        ProductName = productName;
        Price = price;
        StockQuantity = stockQuantity;
        CategoryID = categoryID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getStockQuantity() {
        return StockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        StockQuantity = stockQuantity;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }
}
