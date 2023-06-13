import java.io.*;
import java.util.*;
public class Gondolas {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int x = in.nextInt();
		int[] nums = new int[n];
		for (int i=0; i<n; i++) {
			nums[i] = in.nextInt();
		}
		Arrays.sort(nums);
		int hi = n-1;
		boolean[] taken = new boolean[n];
		int ans=0;
		for (int i=0; i<n; i++) {
			if (taken[i]) continue;
			int target = x-nums[i];
			int pair = binarySearch(nums, i, hi, target, taken);
			if (pair>0) {
				taken[pair] = true;
				hi = pair-1;
			}
			ans++;
		}
		System.out.println(ans);
	}
	// Searching for greatest element <= target in indexes lo-hi
	public static int binarySearch(int[] nums, int lo, int hi, int target, boolean[] taken) {
		if (nums[lo]>target) return -1;
		while (hi>lo) {
			int mid = (hi+lo+1)/2;
			if (nums[mid]<=target && !taken[mid]) lo=mid;
			else hi = mid-1;
		}
	
		return hi;
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
