package org.example.Model;

public class Product {
    private String ProductID;
    private String ProductName;
    private int Price;
    private String SellerName;

    /** constructor */
    public Product(){

    }

    public Product(String productID, String productName, int price, String sellerName) {
        ProductID = productID;
        ProductName = productName;
        Price = price;
        SellerName = sellerName;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
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

    public String getSellerName() {
        return SellerName;
    }

    public void setSellerName(String sellerName) {
        SellerName = sellerName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductID='" + ProductID + '\'' +
                ", ProductName='" + ProductName + '\'' +
                ", Price=" + Price +
                ", SellerName='" + SellerName + '\'' +
                '}';
    }
}
