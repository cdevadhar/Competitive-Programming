import java.io.*;
import java.util.*;
public class SubarraySum {
	static Scanner in;
	static int N;
	static int[] array;
	static int[] prefix;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		N = in.nextInt();
		array = new int[N];
		prefix = new int[N+1];
		for (int i=0; i<N; i++) {
			array[i] = in.nextInt();
			prefix[i] = 0;
		}
		fillPrefix();
		System.out.println(findSum());
	}
	
	public static void fillPrefix() {
		for (int i=0; i<N; i++) {
			prefix[i+1] = prefix[i];
			prefix[i+1]+=array[i];
		}
	}
	
	public static int findSum() {
		int sum=Integer.MIN_VALUE;
		int min = 0;
		for (int i=0; i<N+1; i++) {
			if (prefix[i]<min) min = prefix[i];
			if (prefix[i]-min>sum) sum=prefix[i]-min;
			
		}
		return sum;
	}
}
