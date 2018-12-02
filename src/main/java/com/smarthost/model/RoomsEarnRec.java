package com.smarthost.model;

public class RoomsEarnRec {
    private int roomsUsed;
    private int earned;

    public RoomsEarnRec(int roomsUsed, int earned) {
        this.roomsUsed = roomsUsed;
        this.earned = earned;
    }

    public RoomsEarnRec() {
    }

    public int getRoomsUsed() {
        return roomsUsed;
    }

    public void setRoomsUsed(int roomsUsed) {
        this.roomsUsed = roomsUsed;
    }

    public int getEarned() {
        return earned;
    }

    public void setEarned(int earned) {
        this.earned = earned;
    }

}
