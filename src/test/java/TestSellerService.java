import org.example.DAO.SellerDAO;
import org.example.Model.Seller;
import org.example.Service.SellerService;
import org.example.Util.ConnectionSingleton;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class TestSellerService {

    SellerService sellerService;
    SellerDAO sellerDAO;

    @Before
    public void setUp(){
        Connection conn= ConnectionSingleton.getConnection();
        sellerDAO = new SellerDAO(conn);
        sellerService = new SellerService(sellerDAO);
    }

    @Test
    public void testAdSeller() {
        Seller seller = new Seller();
        seller.setSellerID(UUID.randomUUID().toString());//CREATE UNIQUE SELLERID
        seller.setSellerName("Walmart");//set name for the seller
    }

    /**test addseller details */

    /**public void testAddSeller() {
        Seller seller = new Seller("1","walmart");
        sellerService.addSeller(seller);
        List<Seller> sellerList = sellerService.getSellerList();
        assertEquals(1,sellerList.size());


    }*/



    @Test
    /** test update seller infor */

    /**public void testGetSellerById(){
        String uniqueSellerId = UUID.randomUUID().toString();
        Seller seller = new Seller(uniqueSellerId,"walmart");
        sellerService.addSeller(seller);

        Seller rerievedSeller = sellerService.getSellerById(uniqueSellerId);
        assertNotNull(rerievedSeller);
        assertEquals(seller.getSellerName(),rerievedSeller.getSellerName());

    } */

    public void testGetSellerById() {
        Seller seller = new Seller("1","walmart");
        sellerService.addSeller(seller);
        Seller rerievedSeller = sellerService.getSellerById("1");
        assertNotNull(rerievedSeller);
        assertEquals(seller.getSellerName(),rerievedSeller.getSellerName());
    }


}
