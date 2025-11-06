package project;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private int taxiId;
    private char currentSpot;
    private int earnings;
    private int freeTime;
    private List<Booking> bookings;

    
    Taxi(int taxiId) {
        this.taxiId = taxiId;
        this.currentSpot = 'A';
        this.earnings = 0;
        this.freeTime = 0;
        this.bookings = new ArrayList<>();
    }

    
    public boolean isFree(char pickup, int pickupTime) {
        int travelTime = Math.abs(pickup - currentSpot);
        return (freeTime + travelTime) <= pickupTime;
    }

    
    public void assignBooking(Booking b) {
        bookings.add(b);
    }

   
    public int getTaxiId() {
        return taxiId;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public int getEarnings() {
        return earnings;
    }

    public char getCurrentSpot() {
        return currentSpot;
    }

    public List<Booking> getBookings() {
        return bookings;
    }


    public void setFreeTime(int time) {
        this.freeTime = time;
    }

    public void setEarnings(int amount) {
        this.earnings = amount;
    }

    public void setCurrentSpot(char spot) {
        this.currentSpot = spot;
    }

    
    @Override
    public String toString() {
        return "Taxi ID: " + taxiId +
               ", Current Spot: " + currentSpot +
               ", Free Time: " + freeTime +
               ", Earnings: " + earnings;
    }
}
