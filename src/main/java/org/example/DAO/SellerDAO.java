package org.example.DAO;

import org.example.Model.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.Model.Seller.getSellerID;

public class SellerDAO {
   /** database connection */
   static Connection conn;

    /**constructor*/
    public SellerDAO(Connection conn) {
        this.conn = conn;
    }



    public List<Seller> getAllSeller() {
        List<Seller> sellerresults = new ArrayList<>() ;
        try{
            PreparedStatement ps = conn.prepareStatement("select * from SELLER");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                String SellerID = resultSet.getString("seller_id");
                String SellerName = resultSet.getString("seller_name");
                Seller s = new Seller(SellerID,SellerName);
                sellerresults.add(s);


            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return sellerresults;
    }

    public void insertSeller(Seller s) {
        try{
            PreparedStatement ps = conn.prepareStatement("insert into Seller (seller_id, seller_name) values (?,?)");
            ps.setString(1,s.getSellerID());
            ps.setString(2,s.getSellerName());
            ps.executeUpdate();

            /**retrieve auto generate sellerid
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if(generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                s.setSellerID(String.valueOf(generatedId)); // Set the generated ID back to the Seller object
            } else {
                throw new SQLException("Inserting seller failed, no generated Id to obtained.");
            }*/
        }catch (SQLException e){
            e.printStackTrace();
        }
    }



    public void updateSeller(Seller s){
        try{
            PreparedStatement ps = conn.prepareStatement("UPDATE SELLER set seller_name = ? where seller_id = ?");
            ps.setString(1,s.getSellerName());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void DELETESeller(Seller s) {
        try{
            PreparedStatement ps = conn.prepareStatement("DELETE FROM SELLER WHERE seller_id = ?");
            ps.setString(1,s.getSellerID());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    public Seller getSellerById (String id) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "select * from Seller where seller_id = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String sellerid = rs.getString("seller_id");
                String sellername = rs.getString("seller_name");
                Seller s = new Seller(sellerid, sellername);
                return s;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
