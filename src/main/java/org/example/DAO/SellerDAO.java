package org.example.DAO;

import org.example.Model.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerDAO {
   /** database connection */
    Connection conn;

    /**constructor*/
    public SellerDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Seller> getAllSeller() {
        List<Seller> sellerresults = new ArrayList<>() ;
        try{
            PreparedStatement ps = conn.prepareStatement("select * from Artist");
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
            PreparedStatement ps = conn.prepareStatement("insert into " +
                    "Seller (seller_id, seller_name) values (?, ?)");
            ps.setString(1,s.getSellerID());
            ps.setString(2,s.getSellerName());
            ps.executeUpdate();
        }catch (SQLException e){
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
