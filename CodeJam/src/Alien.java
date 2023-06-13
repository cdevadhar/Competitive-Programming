import java.util.*;
import java.io.*;
public class Alien {
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			int n = in.nextInt();
			ArrayList<String> words = new ArrayList<String>();
			for (int j=0; j<n; j++) {
				String s = in.next();
				
				words.add(s);
			}
		}
	}
	
	public static void pair(ArrayList<String> words) {
		
	}
}
