import org.example.Model.Seller;
import org.example.Service.SellerService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class TestSellerService {
    SellerService sellerService;


    @Before
    public void setUp(){
        sellerService = new SellerService();
    }

    @Test
    /**test addseller details */

    public void testAddSeller() {
        Seller seller = new Seller("1","walmart");
        sellerService.addSeller(seller);
        List<Seller> sellerList = sellerService.getSellerList();
        assertEquals(1,sellerList.size());


    }

    @Test
    /** test update seller infor */

    public void testGetSellerById() {
        Seller seller = new Seller("1","walmart");
        sellerService.addSeller(seller);
        Seller rerievedSeller = sellerService.getSellerById("1");
        assertNotNull(rerievedSeller);
        assertEquals(seller.getSellerName(),rerievedSeller.getSellerName());
    }


}
