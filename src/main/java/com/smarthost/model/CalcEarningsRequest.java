package com.smarthost.model;

import java.io.Serializable;
import java.util.List;

public class CalcEarningsRequest implements Serializable {
    private List<Integer> prices;
    private int freePremiumRooms;
    private int freeEconomyRooms;

    public int getFreePremiumRooms() {
        return freePremiumRooms;
    }

    public void setFreePremiumRooms(int freePremiumRooms) {
        this.freePremiumRooms = freePremiumRooms;
    }

    public int getFreeEconomyRooms() {
        return freeEconomyRooms;
    }

    public void setFreeEconomyRooms(int freeEconomyRooms) {
        this.freeEconomyRooms = freeEconomyRooms;
    }

    public List<Integer> getPrices() {
        return prices;
    }

    public void setPrices(List<Integer> prices) {
        this.prices = prices;
    }
}
