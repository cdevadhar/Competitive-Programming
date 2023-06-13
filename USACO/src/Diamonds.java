import java.util.*;
import java.io.*;
public class Diamonds {
	static int n, k;
	static int[] diamonds;
	static int[] maxLeft;
	static int[] maxRight;
	static int[] leftPrefix;
	static int[] rightPrefix;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("diamond.in", "diamond.out");
		n = in.nextInt();
		k = in.nextInt();
		diamonds = new int[n];
		maxLeft = new int[n];
		maxRight = new int[n];
		leftPrefix = new int[n];
		rightPrefix = new int[n];
		for (int i=0; i<n; i++) {
			diamonds[i] = in.nextInt();
		}
		Arrays.parallelSort(diamonds);
		for (int i=0; i<n; i++) {
			maxLeft[i] = i - binarySearch2(diamonds[i]-k, i) + 1;
			maxRight[i] = binarySearch(diamonds[i]+k, i) - i + 1;
			System.out.println(maxLeft[i] + " " + maxRight[i]);
		}
		leftPrefix[0] = maxLeft[0];
		rightPrefix[n-1] = maxRight[n-1];
		for (int i=1; i<n; i++) {
			leftPrefix[i] = Math.max(leftPrefix[i-1], maxLeft[i]);
			rightPrefix[n-1-i] = Math.max(rightPrefix[n-i], maxRight[n-1-i]);
		}
		int maxTotal = Math.max(leftPrefix[n-1], rightPrefix[0]);
		for (int i=0; i<n-1; i++) {
			maxTotal = Math.max(maxTotal, leftPrefix[i]+rightPrefix[i+1]);
		}
		in.pr.println(maxTotal);
		in.pr.close();
	}
	
	public static int binarySearch(int num, int left) {
		int high = n-1;
		int low = left;
		while (high>low) {
			int mid = (high+low+1)/2;
			if (diamonds[mid]>num) {
				high = mid-1;
			}
			else {
				low = mid;
			}
		}
		return high;
	}
	
	public static int binarySearch2(int num, int right) {
		int high = right;
		int low = 0;
		while (high>low) {
			int mid = (high+low)/2;
			if (diamonds[mid]<num) {
				low = mid+1;
			}
			else {
				high = mid;
			}
		}
		return high;
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO(String fileIn, String fileOut) throws IOException
	    {
	        br = new BufferedReader(
	            new FileReader(fileIn));
	        pr = new PrintWriter(new BufferedWriter(new FileWriter(fileOut)));
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
