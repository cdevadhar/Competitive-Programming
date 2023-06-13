package labs_projects;
/*
 * Deck.java - represents a deck of cards
 * @author - Chinmay Devadhar
 * @author - Period 3
 * @author - Id 10022320
 * @since 02/2022
 */
import java.io.*;
import java.util.*;
/**
 * Deck.java - represents a deck of Cards, which are each an object of the Card class
 * @author - Chinmay Devadhar
 * @author - Period 3
 * @author - Id 10022320
 *
 */
public class Deck {
	private ArrayList<Card> cards;
	// Constructor initializes the list of cards
	public Deck() {
		cards = new ArrayList<Card>();
	}
	// Add a card to the end of our deck
	public void addCard(Card c) {
		cards.add(c);
	}
	// Removes the first card of the list, and returns that value
	public Card draw() {
		return cards.remove(0);
	}
	// A method to shuffle the deck in a random order
	public void shuffle() {
		// Repeat the randomization process a lot to make sure it is properly shuffled
		for (int i=0; i<100; i++) {
			// Start represents the place we remove a card from
			int start = ((int)(Math.random() * cards.size()));
			// End is the random new location we put it in
	        int end = ((int)(Math.random() * cards.size()));
	        // Add the card that was at position start to position end
	        cards.add(end, cards.remove(start)); 
		}
	
	}
	// toString method: either return that the Deck is empty or a string representation of all the cards in it
	public String toString() {
		if (cards.size()==0) return "Deck is empty!";
		String s = "Deck:\n";
		for (Card c: cards) s+=c.toString()+'\n';
		return s;
	}
}
