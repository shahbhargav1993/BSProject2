package org.example.Service;

import org.example.DAO.ProductDAO;
import org.example.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
   /** retrieve all products
    *  list to store  product record
    *  List is an interface that represent an ordered collection of elements. It allows duplicates element and provide
    *  method to add, remove, and access elements in a specific order.
    *  ArrayList is class that implements the List interface */

   /** productlist - it is a variable of type List<Product> .
    * this productlist variable is used to store the product records.
    * getProductList()- this method is used to retrieve the list of products. It return the productList variable.
    * ProductService() constructor- this is the constructor
    * */
   List<Product> productList;
   public List<Product> getProductsList()
    {
    return productList;
    }

   /** constructor */
    public ProductService(ProductDAO productDAO){
        this.productList = new ArrayList<>();
   }

   /** addProduct(Product p) - it is method to add new product to the productList.It takes Product as a object
    * as a parameter and adds it to the list using the add() method of arrayList.*/

   public void addProduct(Product p){
       productList.add(p);
   }

   /** get ID */

   public Product getProductById(String productid) {
       for (Product product : productList) {
           if (product.getProductID().equals(productid))
           {
               return product;
           }
       }
       return null; // Product with the specified ID not found
   }


   /** delete the product from the list */
   public void DELETEProduct(Product product){
       productList.remove(product);
   }

   /** below code -> for loop iteration | we first iterate through the productList using forloop. For each product in the list, we check
    * if its productID matches the one we want to update. If match is found,we update the product's attribute using the set methodu
    * provided by the product class.
    * loop will start from index 0 and continue run until it reachs the end of the list (productList.size())
    * */
    public void updateProduct(String productID, String productName, int price, String sellerName){
        for(int i = 0; i < productList.size(); i++){
            Product product = productList.get(i);
            /** check if the product ID matches the provided ID */
            if (product.getProductID().equals(productID)) {
                /** update the product variables */
                product.setProductName(productName);
                product.setPrice(price);
                product.setSellerName(sellerName);

                /** Replcae the product in the list with the updated product */
                productList.set(i,product);
                break;
            }

        }
    }



}

