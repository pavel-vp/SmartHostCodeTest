package com.smarthost.model;

import java.io.Serializable;
import java.util.List;

public class CustomersRec implements Serializable {
    private List<Integer> customersAsEconomy;
    private List<Integer> customersAsPremium;

    public List<Integer> getCustomersAsEconomy() {
        return customersAsEconomy;
    }

    public void setCustomersAsEconomy(List<Integer> customersAsEconomy) {
        this.customersAsEconomy = customersAsEconomy;
    }

    public List<Integer> getCustomersAsPremium() {
        return customersAsPremium;
    }

    public void setCustomersAsPremium(List<Integer> customersAsPremium) {
        this.customersAsPremium = customersAsPremium;
    }


}

