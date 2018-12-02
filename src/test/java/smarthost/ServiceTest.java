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

    private List<Integer> initList = Arrays.asList(
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

        EarningRec earningRec = customerService.calcEarning(initList, freeEconomyRooms, freePremiumRooms);

        //Usage Premium: 3 (EUR 738)
        assertEquals(earningRec.getPremiumRooms().getRoomsUsed(),3);
        assertEquals(earningRec.getPremiumRooms().getEarned(),738);
        //Usage Economy: 3 (EUR 167)
        assertEquals(earningRec.getEconomyRooms().getRoomsUsed(),3);
        assertEquals(earningRec.getEconomyRooms().getEarned(),167);
    }

    @Test
    public void calcEarning_2_test() {
        //Free Premium rooms: 7
        //Free Economy rooms: 5
        int freePremiumRooms = 7;
        int freeEconomyRooms = 5;

        EarningRec earningRec = customerService.calcEarning(initList, freeEconomyRooms, freePremiumRooms);

        //Usage Premium: 6 (EUR 1054)
        assertEquals(earningRec.getPremiumRooms().getRoomsUsed(),6);
        assertEquals(earningRec.getPremiumRooms().getEarned(),1054);
        //Usage Economy: 4 (EUR 189)
        assertEquals(earningRec.getEconomyRooms().getRoomsUsed(),4);
        assertEquals(earningRec.getEconomyRooms().getEarned(),189);
    }

    @Test
    public void calcEarning_3_test() {
        //Free Premium rooms: 2
        //Free Economy rooms: 7
        int freePremiumRooms = 2;
        int freeEconomyRooms = 7;

        EarningRec earningRec = customerService.calcEarning(initList, freeEconomyRooms, freePremiumRooms);

        //Usage Premium: 2 (EUR 583)
        assertEquals(earningRec.getPremiumRooms().getRoomsUsed(),2);
        assertEquals(earningRec.getPremiumRooms().getEarned(),583);
        //Usage Economy: 4 (EUR 189)
        assertEquals(earningRec.getEconomyRooms().getRoomsUsed(),4);
        assertEquals(earningRec.getEconomyRooms().getEarned(),189);
    }

    @Test
    public void calcEarning_4_test() {
        //Free Premium rooms: 7
        //Free Economy rooms: 1
        int freePremiumRooms = 7;
        int freeEconomyRooms = 1;

        EarningRec earningRec = customerService.calcEarning(initList, freeEconomyRooms, freePremiumRooms);

        //Usage Premium: 7 (EUR 1153)
        assertEquals(earningRec.getPremiumRooms().getRoomsUsed(),7);
        assertEquals(earningRec.getPremiumRooms().getEarned(), 1153);
        //Usage Economy: 1 (EUR 45)
        assertEquals(earningRec.getEconomyRooms().getRoomsUsed(),1);
        assertEquals(earningRec.getEconomyRooms().getEarned(),45);
    }

}





