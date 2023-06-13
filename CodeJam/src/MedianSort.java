import java.io.*;
import java.util.*;
public class MedianSort {
	static Scanner in;
	static int[] medianCount;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		int t = in.nextInt();
		int n = in.nextInt();
		int q = in.nextInt();
		for (int i=0; i<t; i++) {
			medianCount = new int[n+1];
			
			sort(n);
			for (int j=0; j<n+1; j++) {
				System.out.println(medianCount[j]);
			}
		}
	}
	
	public static void sort(int n) {
		int x=0;
		for (int i=1; i<n+1; i++) {
			for (int j=i+1; j<n+1; j++) {
				for (int k = j+1; k<n+1; k++) {
					System.out.println(i+" " + j+" " + k);
					if (in.hasNext()) {
						int s = in.nextInt();
						medianCount[s] += 1;
					}
					
				}
			}
		}
		int[] positionsRight = new int[n/2];
		int[] positionsLeft = new int[n/2];
		
		
	}
}
