package com.smarthost.service;

import com.smarthost.model.CustomersRec;
import com.smarthost.model.EarningRec;
import com.smarthost.model.RoomsEarnRec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        Comparator<? super Integer> reversalComparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2) * (-1);
            }
        };
        Collections.sort(customersRec.getCustomersAsEconomy(), reversalComparator);
        Collections.sort(customersRec.getCustomersAsPremium(), reversalComparator);
        return customersRec;
    }


    public EarningRec calcEarning(CustomersRec custs, int freeEconomyRooms, int freePremiumRooms) {
        EarningRec earningRec = new EarningRec();
        earningRec.setEconomyRooms(new RoomsEarnRec());
        earningRec.setPremiumRooms(new RoomsEarnRec());

        // For the first, lets fill Premium clients into rooms
        for (int price : custs.getCustomersAsPremium()) {
            if (freePremiumRooms > 0) {
                earningRec.getPremiumRooms().setRoomsUsed(earningRec.getPremiumRooms().getRoomsUsed() + 1);
                earningRec.getPremiumRooms().setEarned(earningRec.getPremiumRooms().getEarned() + price);
                freePremiumRooms--;
            }
        }

        // then, try to fill economy customers
        for (int price : custs.getCustomersAsEconomy()) {
            if (freePremiumRooms > 0) {
                earningRec.getEconomyRooms().setRoomsUsed(earningRec.getEconomyRooms().getRoomsUsed() + 1);
                earningRec.getEconomyRooms().setEarned(earningRec.getEconomyRooms().getEarned() + price);
                freePremiumRooms--;
            } else {
                if (freeEconomyRooms > 0) {
                    earningRec.getEconomyRooms().setRoomsUsed(earningRec.getEconomyRooms().getRoomsUsed() + 1);
                    earningRec.getEconomyRooms().setEarned(earningRec.getEconomyRooms().getEarned() + price);
                    freeEconomyRooms--;
                }
            }
        }
        return earningRec;
    }
}
