package org.example.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import org.example.Model.Product;
import org.example.Model.Seller;
import org.example.Service.ProductService;
import org.example.Service.SellerService;

import java.util.List;

/** StoreController class handling HTTP request related to Product and Seller */
public class StoreController {
     ProductService productService;
     SellerService sellerService;

    /** constructor */
     public StoreController(ProductService productService, SellerService sellerService) {
        this.productService = productService;
        this.sellerService = sellerService;
    }

    /** getAPi() method return Javalin instance. initialize newjavalin instance*/
    public Javalin getAPI() {
        Javalin api = Javalin.create();

        api.get("health", context -> {context.result("Server is UP");});

        /** GET endpoint retrieves all products using product servie , convert list into json and sends it as Response. same for seller as well*/
        api.get("products", context -> {
            List<Product> productList = productService.getProductsList();
            context.json(productList);
        });

        api.get("sellers", context -> {
            List<Seller> sellerList = sellerService.getSellerList();
            context.json(sellerList);
        });

        /** POSt endpoint- it access JSOn input,parse json into product objext, add prodct using productservice , set http request 201(created), 400(bad request) */
        api.post("products", context -> {
            try {
                ObjectMapper om = new ObjectMapper();
                Product product = om.readValue(context.body(), Product.class);
                productService.addProduct(product);
                context.status(201);
            } catch (JsonProcessingException e) {
                context.status(400).result("Bad Request: Error Procesing JSON data-" + e.getOriginalMessage());;
            }
        });

        api.post("sellers", context -> {
            try {
                ObjectMapper om = new ObjectMapper();
                Seller seller = om.readValue(context.body(), Seller.class);
                sellerService.addSeller(seller);
                context.status(201);
            } catch (JsonProcessingException e) {
                context.status(400).result("Bad Request: Error Procesing JSON data-" + e.getOriginalMessage());
            }
        });

        /**  Get endpoint retrieved id using path parameter from product service. send response if found or not found, 404 - not found*/
        api.get("products/{id}", context -> {
            try {
                String id = context.pathParam("id");
                Product product = productService.getProductById(id);
                if (product == null) {
                    context.status(404);
                } else {
                    context.json(product);
                    context.status(200);
                }
            }catch(NumberFormatException e){
                    context.status(400).result("Invalid Product ID format");
                }
            }
        );

        api.get("sellers/{id}", context -> {
                    try {
                        String id = context.pathParam("id");
                        Seller seller = sellerService.getSellerById(id);
                        if (seller == null) {
                            context.status(404);
                        } else {
                            context.json(seller);
                            context.status(200);
                        }
                    } catch (NumberFormatException e) {
                        context.status(400).result("Invalid Product ID format");
                    }
                }

        );

        return api;
    }

}
