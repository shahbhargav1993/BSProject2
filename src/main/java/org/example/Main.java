package org.example;

import io.javalin.Javalin;
import org.example.Controller.StoreController;
import org.example.DAO.ProductDAO;
import org.example.DAO.SellerDAO;
import org.example.Service.ProductService;
import org.example.Service.SellerService;
import org.example.Util.ConnectionSingleton;

import java.sql.Connection;


public class Main {
    public static void main(String[] args) {
        Connection conn = ConnectionSingleton.getConnection();
        SellerDAO sellerDAO = new SellerDAO(conn);
        ProductDAO productDAO = new ProductDAO(conn);
        SellerService sellerService = new SellerService(sellerDAO);
        ProductService productService = new ProductService(productDAO);
        StoreController storeController = new StoreController(productService,sellerService);

        Javalin api = storeController.getAPI();

        api.start(9001);



    }
}