package smarthost;


import com.smarthost.model.CustomersRec;
import com.smarthost.model.EarningRec;
import com.smarthost.service.CustomerService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ServiceTest {

    List<Integer> initList = Arrays.asList(
            23,
            45,
            155,
            374,
            22,
            99,
            100,
            101,
            115,
            209);

    private CustomerService customerService;

    @Before
    public void setUp() {
        customerService = new CustomerService();
    }

    @Test
    public void divideListOnTwo_test() {
        CustomersRec custs = customerService.divideCustomers(initList);

        assertNotEquals(custs, null);
        assertEquals(custs.getCustomersAsEconomy().size(), 4);
        assertEquals(custs.getCustomersAsPremium().size(), 6);

    }


    @Test
    public void calcEarning_1_test() {
        //Free Premium rooms: 3
        //Free Economy rooms: 3
        int freePremiumRooms = 3;
        int freeEconomyRooms = 3;

        CustomersRec custs = customerService.divideCustomers(initList);
        EarningRec earningRec = customerService.calcEarning(custs, freeEconomyRooms, freePremiumRooms);

        //Usage Premium: 3 (EUR 738)
        assertEquals(earningRec.getPremiumRooms().getRoomsUsed(),3);
        assertEquals(earningRec.getPremiumRooms().getEarned(),738);
        //Usage Economy: 3 (EUR 167)
        assertEquals(earningRec.getEconomyRooms().getRoomsUsed(),3);
        assertEquals(earningRec.getEconomyRooms().getEarned(),167);

    }

}





