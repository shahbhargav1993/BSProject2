package org.example.Service;

import org.example.Model.Product;
import org.example.Model.Seller;

import java.util.ArrayList;
import java.util.List;

public class SellerService {

    /** List to store seller records  in the sellerList variable. It is used to store records of seller*/
    List<Seller> sellerList;

    /** define method to get all seller list from seller  */
    public List<Seller> getSellerList() {
        return sellerList;
    }

    /** constructor to initialize the sellerList as an ArrayList */

    public  SellerService () {
        this.sellerList = new ArrayList<>();
    }

    /** add method = add new seller to seller List */
    public void addSeller(Seller s) {
        sellerList.add(s);
    }

    /** get seller ID*/

    public Seller getSellerById(String sellerId) {
        for (Seller seller : sellerList) {
            if (seller.getSellerID().equals(sellerId)) {
                return seller;
            }
        }
        return null; // Seller with the specified ID not found
    }

   /** delete from list */
    public void deleteSeller(Seller s) {
        sellerList.remove(s);
    }

    public void updateSeller(String sellerID, String sellerName,Seller s) {
        for(int i = 0; i < sellerList.size(); i++){
            Seller seller = sellerList.get(i);
            /** check if the seller ID matches the provided ID */
            if (Seller.getSellerID().equals(sellerID)) {
                /** update the product variables */
                s.setSellerID(sellerID);
                s.setSellerName(sellerName);


                /** Replcae the product in the list with the updated product */
                sellerList.set(i,s);
                break;
            }

        }
    }



}

