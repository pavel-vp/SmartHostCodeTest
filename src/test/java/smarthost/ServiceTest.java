package smarthost;


import com.smarthost.model.CustomersRec;
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

}





