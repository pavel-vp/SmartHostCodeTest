package com.smarthost.service;

import com.smarthost.model.CustomersRec;
import com.smarthost.model.EarningRec;
import com.smarthost.model.RoomsEarnRec;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CustomerService {

    public CustomersRec divideCustomers(List<Integer> initList) {
        CustomersRec customersRec = new CustomersRec();
        customersRec.setCustomersAsEconomy(new ArrayList<>());
        customersRec.setCustomersAsPremium(new ArrayList<>());

        for (Integer price : initList) {
            if (price < 100) {
                customersRec.getCustomersAsEconomy().add(price);
            } else {
                customersRec.getCustomersAsPremium().add(price);
            }
        }
        Comparator<Integer> reversalComparator = (o1, o2) -> o1.compareTo(o2) * (-1);
        customersRec.getCustomersAsEconomy().sort(reversalComparator);
        customersRec.getCustomersAsPremium().sort(reversalComparator);
        return customersRec;
    }


    public EarningRec calcEarning(List<Integer> initList, int freeEconomyRooms, int freePremiumRooms) {
        CustomersRec customersRec = divideCustomers(initList);

        int economyRooms = 0, economyEarned = 0, premiumRooms = 0, premiumEarned = 0;

        // For the first, lets fill Premium clients into rooms
        for (int price : customersRec.getCustomersAsPremium()) {
            if (freePremiumRooms > 0) {
                premiumRooms++;
                premiumEarned += price;
                freePremiumRooms--;
            }
        }

        boolean isUpgrade = customersRec.getCustomersAsEconomy().size() > freeEconomyRooms;
        // then, try to fill economy customers
        for (int price : customersRec.getCustomersAsEconomy()) {
            if (freePremiumRooms > 0 &&
                    isUpgrade ) {
                premiumRooms++;
                premiumEarned += price;
                freePremiumRooms--;
            } else {
                if (freeEconomyRooms > 0) {
                    economyRooms++;
                    economyEarned += price;
                    freeEconomyRooms--;
                }
            }
        }
        return new EarningRec(new RoomsEarnRec(economyRooms, economyEarned),
                              new RoomsEarnRec(premiumRooms, premiumEarned));
    }
}
