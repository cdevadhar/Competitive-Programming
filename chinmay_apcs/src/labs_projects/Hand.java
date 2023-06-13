package labs_projects;
import java.io.*;
import java.util.*;
/*
 * Hand.java - represents a hand of cards
 * @author - Chinmay Devadhar
 * @author - Period 3
 * @author - Id 10022320
 * @since 02/2022
 */
public class Hand {
	private ArrayList<Card> cards;
	// Initializes the list of cards
	public Hand() {
		cards = new ArrayList<Card>();
	}
	// Adds a card to our hand
	public void addCard(Card c) {
		cards.add(c);
	}
	
	// Checks if our list of cards is empty (we can jsut use the ArrayList function
	public boolean isEmpty() {
		return cards.isEmpty();
	}
	
	// Sorts the cards using selection sort
	public void sort() {
		for (int i=0; i<cards.size()-1; i++) {
			int minIndex = i;
			for (int j=i+1; j<cards.size(); j++) {
				// Compares the cards based on their order - see how this is set in the Card class
				if (cards.get(j).getOrder()<cards.get(minIndex).getOrder()) minIndex = j;
			}
			// Sets the current index to the minimum value in the unsorted portion
			// We also have to put the value of our current index at the value of the previous minimum value, but we can do it in one line
			// Because set() returns the previous value at that index
			cards.set(i, cards.set(minIndex, cards.get(i)));
		}
	}
	
	// Returns whether the hand is empty or the string representation of all the cards in the hand
	public String toString() {
		if (isEmpty()) return "Hand is empty!\n";
		String s = "Hand:\n";
		for (Card c: cards) s+=c.toString()+'\n';
		return s;
	}
}
