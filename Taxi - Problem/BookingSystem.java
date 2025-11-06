package project;

import java.util.*;

public class BookingSystem {
  private List<Taxi> taxis;
  int bookingId =1;
    BookingSystem(int taxiCount){

      taxis = new ArrayList<>();
      for(int i = 1 ; i <= taxiCount; i++){
      
        taxis.add(new Taxi(i));
      
      }
    }



    private int calculateCharges(char pickup , char drop ){
      int dist = Math.abs(pickup - drop) *15;
      int charges =100;
      dist -=5;
      charges += dist * 10;
      return charges;
    }
    



    private Taxi findTaxi(char pickup , int pickupTime){


      List<Taxi> freeTaxis = new ArrayList<>();
      for(Taxi t : taxis){
        if(t.isFree(pickup , pickupTime)){
          freeTaxis.add(t);
        }
      }

      if(freeTaxis.isEmpty()){
        return null;
      }

      int minDist = Integer.MAX_VALUE;
      for(Taxi t : taxis){
        int dist = Math.abs(t.getCurrentSpot() - pickup);
        if(dist < minDist){
          minDist  = dist;
        }
      }

      List<Taxi> closest = new ArrayList<>();

      for(Taxi t :taxis){
        int dist = Math.abs(t.getCurrentSpot() - pickup);
        if(dist == minDist){
          closest.add(t);
        }
      }

      Taxi selectedTaxi = closest.get(0);
      for(Taxi t : closest){
        if(t.getEarnings() < selectedTaxi.getEarnings()){
          selectedTaxi = t;
        }
      }

      return selectedTaxi;
    }





    void bookTaxi(Customer c){

      Taxi selected = findTaxi(c.getPickup() , c.getPickTime());

      if(selected == null){
        System.out.println("No taxi available");
        return; 
      }
      int travelTime = Math.abs(c.getDrop() - c.getPickup());
      int dropTime = c.getPickTime() + travelTime;
      int amount = calculateCharges(c.getPickup() , c.getDrop()); 

      Booking booking = new Booking(bookingId++ ,dropTime , amount , c);

      selected.assignBooking(booking);

      selected.setFreeTime(dropTime);
      selected.setEarnings(amount + selected.getEarnings());
      selected.setCurrentSpot(c.getDrop());

      System.out.println("Booking successful with Taxi ID: " + selected.getTaxiId() + ", Booking ID: " + booking.getBookingId() + ", Amount: " + amount);


    }

    void displayTaxi(){
      for(Taxi t : taxis){
        System.out.println("Taxi ID: " + t.getTaxiId() + ", Earnings: " + t.getEarnings());
        System.out.println("Bookings:");
        for(Booking b : t.getBookings()){ 
          Customer c = b.getCustomer();
          System.out.println("  Booking ID: " + b.getBookingId() + ", Customer ID: " + c.getId() + ", From: " + c.getPickup() + ", To: " + c.getDrop() + ", Pickup Time: " + c.getPickTime() + ", Drop Time: " + b.getDropTime() + ", Amount: " + b.getAmount());
        }
        
      }

    }

}
