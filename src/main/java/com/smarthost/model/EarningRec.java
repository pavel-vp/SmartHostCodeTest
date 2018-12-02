package com.smarthost.model;

public class EarningRec {
    private RoomsEarnRec economyRooms;
    private RoomsEarnRec premiumRooms;

    public EarningRec(RoomsEarnRec economyRooms, RoomsEarnRec premiumRooms) {
        this.economyRooms = economyRooms;
        this.premiumRooms = premiumRooms;
    }

    public EarningRec() {
    }

    public RoomsEarnRec getEconomyRooms() {
        return economyRooms;
    }

    public void setEconomyRooms(RoomsEarnRec economyRooms) {
        this.economyRooms = economyRooms;
    }

    public RoomsEarnRec getPremiumRooms() {
        return premiumRooms;
    }

    public void setPremiumRooms(RoomsEarnRec premiumRooms) {
        this.premiumRooms = premiumRooms;
    }
}
