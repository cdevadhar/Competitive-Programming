package labs_projects;
/**
 * MagpieRunner.java
 * @author - Chinmay Devadhar, Mehul Nair
 * @author - Period 3
 * @author - Id 10022320
 *
 */ 
import java.io.*;
import java.util.*;
// This class runs our chatbot's methods so we can have a conversation with it
public class MagpieRunner {
	static Scanner in;
	static Magpie4 m;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		//Initialize the scanner and Magpie4 objects
		m = new Magpie4();
		// First print the initial greeting, then get the user's input
		System.out.println(m.getGreeting());
		String curr = in.nextLine();
		// Use a while loop to keep the conversation going if the user doesn't say "Bye"
		while (!curr.toLowerCase().equals("bye")) {
			System.out.println(m.getResponse(curr));
			
			curr = in.nextLine();
			
		}
	}
	
}