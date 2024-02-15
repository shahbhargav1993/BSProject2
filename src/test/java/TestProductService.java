import org.example.Model.Product;
import org.example.Service.ProductService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.*;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;

public class TestProductService {
    ProductService productService;

    @Before
    public void setup() {
        productService = new ProductService();
    }

    @Test
    /** add product test format */
    public void testAddProduct() {
        Product product = new Product("1","Butter",10,"walmart");
        productService.addProduct(product);
        List<Product> productList = productService.getProductsList();
        assertEquals(1,productList.size());
    }

    @Test
    /**get product by ID */

    public void  testGetProductById() {
        Product product = new Product("1","Butter",10,"walmart");
        productService.addProduct(product);
        Product retrieveProduct = productService.getProductById("1");
        assertNotNull(retrieveProduct);
        assertEquals(product.getProductName(),retrieveProduct.getProductName());

    }



}
