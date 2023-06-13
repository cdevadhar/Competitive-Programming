import java.io.*;
import java.util.*;
public class Books {
	static int n, t;
	static int[] bookTimes;
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		n = in.nextInt();
		t = in.nextInt();
		bookTimes = new int[n];
		for (int i=0; i<n; i++) {
			bookTimes[i] = in.nextInt();
		}
		System.out.println(maxBooks());
	}
	
	public static int maxBooks() {
		int count=0;
		for (int i=0; i<n; i++) {
			if (bookTimes[i]<=t) {
				count++;
				t-=bookTimes[i];
//				System.out.println(bookTimes[i]);
			}
			

		}
		return count;
	}
	
	
}
