package org.example.DAO;

import org.example.Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    Connection conn;
    /** constructor */
    public ProductDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Product> getAllProduct(){
        List<Product> resultProducts = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from PRODUCT");
            ResultSet rs = ps.executeQuery();


            while(rs.next()){
                String ProductID = rs.getString("product_id");
                String ProductName = rs.getString("product_name");
                int Price = rs.getInt("price_item");
                String SellerName = rs.getString("seller_name");
                Product p = new Product(ProductID,ProductName,Price,SellerName);
                resultProducts.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultProducts;
    }


    public Product getProductID(String id){
        try{
            PreparedStatement ps = conn.prepareStatement("select * from PRODUCT where product_id =?");
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String ProductID = rs.getString("product_id");
                String ProductName = rs.getString("product_name");
                int Price = rs.getInt("price_item");
                String SellerName = rs.getString("seller_name");
                Product p = new Product(ProductID,ProductName,Price,SellerName);
                return p;

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public void insertProduct(Product p) {
        try {
            System.out.println(p.getProductID());
            PreparedStatement ps = conn.prepareStatement("insert into PRODUCT (product_id,product_name,price_item,seller_name) values (?,?,?,?)");
            ps.setString(1, p.getProductID());
            ps.setString(2, p.getProductName());
            ps.setInt(3, p.getPrice());
            ps.setString(4, p.getSellerName());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DELETEProduct(Product p){
        try{
            PreparedStatement ps = conn.prepareStatement("DELETE FROM PRODUCT WHERE product_id = ?");
            ps.setString(1, p.getProductID());
            ps.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updateProduct(Product p) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE PRODUCT set product_name =?,price_item =?,seller_name=? where product_id =?");
            ps.setString(1, p.getProductName());
            ps.setInt(2, p.getPrice());
            ps.setString(3, p.getSellerName());
            ps.setString(4, p.getProductID());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





















}
