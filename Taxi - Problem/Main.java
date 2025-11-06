package project;

public class Main {
  public static void main(String[] args) {
    Customer customer1 = new Customer(1, 'A', 'B', 9);
    Customer customer2 = new Customer(2, 'B', 'D', 9); 
    Customer customer3 = new Customer(3, 'B', 'C', 12);

    BookingSystem bookingSystem = new BookingSystem(4);
    bookingSystem.bookTaxi(customer1);
    bookingSystem.bookTaxi(customer2);
    bookingSystem.bookTaxi(customer3);

  }
}
