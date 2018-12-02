package smarthost;


import com.smarthost.model.CustomersRec;
import com.smarthost.service.CustomerService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

        assertEquals(custs, null);
    }
}





