package org.example;

import io.javalin.Javalin;
import org.example.Controller.StoreController;
import org.example.Service.ProductService;
import org.example.Service.SellerService;


public class Main {
    public static void main(String[] args) {
        // Initialize services
        ProductService productService = new ProductService();
        SellerService sellerService = new SellerService();

        // Initialize controller
        StoreController storeController = new StoreController(productService, sellerService);

        // Setup Javalin
        Javalin app = storeController.getAPI();

        // Start the server
        app.start(9004); // You can specify the port number here

        // Display message indicating that the server has started
        System.out.println("Server started at http://localhost:9004/");
    }
}