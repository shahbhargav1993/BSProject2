import org.example.DAO.SellerDAO;
import org.example.Model.Seller;
import org.example.Service.SellerService;
import org.example.Util.ConnectionSingleton;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

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
