package com.smarthost;

import com.smarthost.model.CalcEarningsRequest;
import com.smarthost.model.EarningRec;
import com.smarthost.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "checkavailability")
public class CustomerController {

    private final
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("")
    public EarningRec calcEarnings(@RequestBody CalcEarningsRequest request) {

        return customerService.calcEarning(request.getPrices(), request.getFreeEconomyRooms(), request.getFreePremiumRooms());

    }


}
