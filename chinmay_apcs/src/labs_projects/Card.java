package labs_projects;
/*
 * Card.java: represents a Card with a specific value and suit
 * @author - Chinmay Devadhar
 * @author - Period 3
 * @author - Id 10022320
 * @since 02/2022
 */
public class Card {
	// Private instance variables storing the attributes of each card
	private String suit;
	private String value;
	private int order;
	//Constructor takes in the suit and value of each card
	public Card(String value, String suit) {
		this.suit = suit;
		this.value = value;
		
		// The face cards have special values, so we need to set their order appropriately
		if (value.equals("Ace")) this.order = 1;
		else if (value.equals("Jack")) this.order = 11;
		else if (value.equals("Queen")) this.order = 12;
		else if (value.equals("King")) this.order = 13;
		
		// For other cards, the order is just equal to their value
		else this.order = Integer.parseInt(value);
	}
	
	// Getter methods for all private instance variables
	public String getSuit() {
		return suit;
	}
	public String getValue() {
		return value;
	}
	public int getOrder() {
		return order;
	}
	
	// toString returns the value and suit of the card
	public String toString() {
		return value + " of " + suit;
	}
}
