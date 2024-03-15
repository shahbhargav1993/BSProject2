package org.example.Model;

public class Seller {
    private  String SellerID;
    private String SellerName;

    public Seller() {

    }



    public Seller(String sellerID, String sellerName) {
        SellerID = sellerID;
        SellerName = sellerName;
    }

    public String getSellerID() {
        return SellerID;
    }

    public void setSellerID(String sellerID) {
        SellerID = sellerID;
    }

    public String getSellerName() {
        return SellerName;
    }

    public void setSellerName(String sellerName) {
        SellerName = sellerName;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "SellerID='" + SellerID + '\'' +
                ", SellerName='" + SellerName + '\'' +
                '}';
    }


}
