package com.smarthost.service;

import com.smarthost.model.CustomersRec;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public CustomersRec divideCustomers(List<Integer> initList) {
        CustomersRec customersRec = new CustomersRec();
        customersRec.setCustomersAsEconomy(new ArrayList<Integer>());
        customersRec.setCustomersAsPremium(new ArrayList<Integer>());

        for (Integer price : initList) {
            if (price < 100) {
                customersRec.getCustomersAsEconomy().add(price);
            } else {
                customersRec.getCustomersAsPremium().add(price);
            }
        }

        return customersRec;
    }



}
