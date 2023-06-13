package labs_projects;

/**
 * TeddyBearInventory.java - Unit 5 lab 
 *
 * @author - Chinmay Devadhar
 * @date - 12/2021
 * @id - 10022320
 * I received help from no one.
 */ 
public class TeddyBearInventory {
	private String size;
	private int count;
	private double cost, price;
	private static int totalCount;
	private static double totalCost, totalProfit;
	//All instance variables and static variables are private
	
	//Constructor 1: takes in a String size and sets the size to that, sets the other variables to 0
	public TeddyBearInventory(String size) {
		this.size = size;
		count=0;
		cost=0;
		price=0;
	}
	
	//Constructor 2: takes in parameters for all instance variables and uses them to set the values.
	//Updates the totalCount and totalCost static variables accordingly
	public TeddyBearInventory(String size, int count, double cost, double price) {
		//Use the this keyword to differentiate between the local and instance variables
		this.size = size;
		this.count = count;
		this.cost = cost;
		this.price = price;
		totalCount+=count;
		totalCost+=count*cost;
	}
	
	//Add a bear to the inventory: this is buying a bear at the current cost
	//The total cost is updated
	public void addBear(int count) {
		this.count+=count;
		totalCount+=count;
		totalCost+=count*cost;
	}
	
	//Sell count number of bears at the current price
	//If count is more than the number of bears we have, we cant sell that many bears. So return false.
	//Otherwise, sell the bears, update the profit and count variables, and return true
	public boolean sellBear(int count) {
		if (count>this.count) return false;
		this.count-=count;
		totalCount-=count;
		totalProfit+=count*price;
		return true;
	}
	
	//The toString method returns information about the inventory's price, cost, number, and size of bears
	public String toString() {
		return count + " " + size + " teddy bears. Cost: $" + cost + ". Price: $" + price + ".";
	}
	
	//Getters for all private and instance variables
	public double getCost() {
		return cost;
	}
	public double getPrice() {
		return price;
	}
	public String getSize() {
		return size;
	}
	public int getCount() {
		return count;
	}
	public static int getTotalCount() {
		return totalCount;
	}
	public static double getTotalCost() {
		return totalCost;
	}
	public static double getTotalProfit() {
		return totalProfit;
	}
	
	//Setters for cost and price variables
	public void setCost(double newCost) {
		cost = newCost;
	}
	
	public void setPrice(double newPrice) {
		price= newPrice;
	}
	
}
