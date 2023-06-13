import java.io.*;
import java.util.*;
public class ArrayDiv {
	static int n, k;
	static int[] numbers;
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		numbers = new int[n];
		for (int i=0; i<n; i++) {
			numbers[i] = in.nextInt();
		}
		for (int i=1; i<20; i++) {
			System.out.println(i + ": " + canSum(i));
		}
		System.out.println(search());
	}
	
	public static int search() {
		int high = 1000000000;
		int low = 0;
		while (high>low) {
			if (canSum((high+low)/2)) {
				high = (high+low)/2;
			}
			else {
				low = (high+low)/2 + 1;
			}
		}
		return high;
	}
	
	public static boolean canSum(int sum) {
		int currentsum  = 0;
		int subarrays = 1;
		for (int i=0; i<n; i++) {
			if (currentsum+numbers[i]<=sum) {
				currentsum+=numbers[i];
			}
			else {
				
				if (currentsum>sum) return false;
				currentsum = numbers[i];
				subarrays++;
				
			}
			
		}
		if (subarrays<=k) return true;
		return false;
	}
}
