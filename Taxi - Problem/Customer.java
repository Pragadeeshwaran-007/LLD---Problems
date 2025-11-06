package project;
public class Customer{


	private int customerId;
	
	private char pickup;

	private char drop;

	private int pickupTime;


	Customer(int id , char start , char end , int pickTime){

		this.customerId = id;

		this.pickup = start;

		this.drop = end;

		this.pickupTime =  pickTime;
	

	}


	public int getId (){

		return customerId; 
	}

	public char getPickup(){

		return pickup;
	}

	public char getDrop(){

		return drop;
	}

	public int getPickTime(){

		return pickupTime;
	}




}
