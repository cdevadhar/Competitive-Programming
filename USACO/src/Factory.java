import java.io.*;
import java.util.*;
public class Factory {
	static int n, t;
	static int[] machines;
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		n = in.nextInt();
		t = in.nextInt();
		machines = new int[n];
		for (int i=0; i<n; i++) {
			machines[i] = in.nextInt();
		}
		for (int i=0; i<15; i++) {
			System.out.println(canProduce(i));
		}
		System.out.println(search());
	}
	
	public static int search() {
		int high = 1000000000;
		int low = 0;
		while (high>low) {
			if (canProduce((high+low)/2)) {
				high = (high+low)/2;
			}
			else {
				low = (high+low)/2 +1;
			}
		}
		return high;
	}
	
	public static boolean canProduce(int time) {
		int total=0;
		for (int i=0; i<n; i++) {
			int products = time/machines[i];
			total+=products;
		}
		if (total>= t) return true;
		return false;
	}
}
