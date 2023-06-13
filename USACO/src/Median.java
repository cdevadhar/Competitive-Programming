import java.util.*;
import java.io.*;
public class Median {
	static int[] numbers;
	static int n;
	static int k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("USACOInput1"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		numbers = new int[n];
		StringTokenizer line = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			numbers[i]=Integer.parseInt(line.nextToken());
		}
		Arrays.sort(numbers);
		
		System.out.println(search(0, 10));
	}
	
	public static int search(int lo, int hi) {
		int result=lo-1;
		while(lo<=hi) {
			int mid = (lo+hi)/2;
			if (isItPossible(mid)) {
				lo=mid+1;
				result=mid;
			}
			else {
				hi=mid-1;
			}
		}
		return result;
	}
	
	public static boolean isItPossible(int median) {
		int operations=0;
		for (int i=(n-1)/2; i<n; i++) {
			operations+=(median-numbers[i]);
		}
		return operations<=k;
	}
}
