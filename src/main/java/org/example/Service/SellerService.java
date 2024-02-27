package org.example.Service;

import org.example.DAO.SellerDAO;
import org.example.Model.Seller;

import java.util.ArrayList;
import java.util.List;

public class SellerService {
SellerDAO sellerDAO;
    /** List to store seller records  in the sellerList variable. It is used to store records of seller*/

    /** constructor to initialize the sellerList */

    public  SellerService(SellerDAO sellerDAO) {
        this.sellerDAO = sellerDAO;
    }

    /** define method to get all seller list from seller  */
    public List<Seller> getSellerList() {
        return sellerDAO.getAllSeller();
    }



    /** add method = add new seller to seller List */
    public void addSeller(Seller s) {
        sellerDAO.insertSeller(s);
    }

    /** get seller ID*/

    public Seller getSellerById(String sellerId) {
        return sellerDAO.getSellerById(sellerId);
    }

   /** delete from list */
    public void DELETESeller(Seller s) {
        SellerDAO.DELETESeller(s);
    }

    public void updateSeller(String sellerID, String sellerName,Seller s) {

            Seller seller = sellerDAO.getSellerById(sellerID);
            /** check if the seller ID matches the provided ID */
            if (Seller.getSellerID().equals(sellerID)) {
                /** update the product variables */
                s.setSellerID(sellerID);
                s.setSellerName(sellerName);
                sellerDAO.updateSeller(seller);

            }

    }




}

