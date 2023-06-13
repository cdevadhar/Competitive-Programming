import java.io.*;
import java.util.*;

public class ArrayGame {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		int[] rightIncreasing = new int[n];
		int[] leftIncreasing = new int[n];
		int streak = 0;
		int previous = -1;
		for (int i=0; i<n; i++) {
			if (arr[i]>previous) {
				streak++;
			}
			else {
				streak = 0;
			}
			leftIncreasing[i] = streak;
			previous = arr[i];
		}
		streak = 0;
		previous = -1;
		for (int i=n-1; i>=0; i--) {
			if (arr[i]>previous) {
				streak++;
			}
			else {
				streak = 0;
			}
			rightIncreasing[i] = streak;
			previous = arr[i];
		}
		previous = -1;
		int right = n-1;
		int left = 0;
		boolean done = false;
		int move = 0;
		String winner = "";
		while (!done) {
			if (arr[right]>previous && arr[left]>previous) {
				if (arr[right]==arr[left]) {
					int sequenceA = leftIncreasing[right];
					int sequenceB = rightIncreasing[left];
					if (sequenceA%2==0 || sequenceB%2==0) {
						if (move%2==0) winner = "Alice";
						else winner = "Bob";
						break;
					}
					else {
						if (move%2==1) winner = "Bob";
						else winner = "Alice";
						break;
					}
				}
				else if (arr[right]>arr[left]) {
					int sequence = leftIncreasing[right];
					if (sequence%2==0) {
						if (move%2==0) winner = "Alice";
						else winner = "Bob";
						break;
					}
					else {
						left++;
						move++;
						continue;
					}
				}
				else {
					int sequence = rightIncreasing[left];
					if (sequence%2==0) {
						if (move%2==0) winner = "Alice";
						else winner = "Bob";
						break;
					}
					else {
						right--;
						move++;
						continue;
					}
				}
			}
			else if (arr[right]<=previous && arr[left]>previous) {
				
			}
			else if (arr[right]>previous && arr[left]<=previous) {
				
			}
			else {
				
			}
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(
	           new InputStreamReader(System.in));

	    }
	    

	    public String next() throws IOException
	    {
	        while (st == null || !st.hasMoreElements()) {
	           
	            st = new StringTokenizer(br.readLine());
	        }
	        return st.nextToken();
	    }

	    public int nextInt() throws NumberFormatException, IOException { return Integer.parseInt(next()); }

	    public long nextLong() throws NumberFormatException, IOException { return Long.parseLong(next()); }

	    public double nextDouble() throws NumberFormatException, IOException
	    {
	        return Double.parseDouble(next());
	    }

	    public String nextLine() throws IOException
	    {
	        String str = br.readLine();
	        return str;
	    }
	}
}
