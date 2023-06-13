import java.io.*;
import java.util.*;
public class MaxMedian {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int k = in.nextInt();
		int[] nums = new int[n];
		int[] sorted = new int[n];
		for (int i=0; i<n; i++) {
			nums[i] = in.nextInt();
			sorted[i] = nums[i];
		}
		Arrays.parallelSort(sorted);
		int hi = n-1;
		int lo = 0;
		while (hi>lo) {
			int mid = (hi+lo+1)/2;
			if (doesWork(sorted[mid], nums, k)) lo = mid;
			else hi = mid-1;
		}
		System.out.println(sorted[hi]);
	}
	public static boolean doesWork(int median, int[] nums, int k) {
		int[] arr = new int[nums.length];
		int[] prefix = new int[nums.length+1];
		int[] prefixMin = new int[nums.length+1];
		
		
		for (int i=0; i<nums.length; i++) {
			if (nums[i]>=median) {
				arr[i] = 1;
			}
			else {
				arr[i] = -1;
			}
			prefix[i+1] = prefix[i]+arr[i];
			prefixMin[i+1] = Math.min(prefixMin[i], prefix[i+1]);
			
		}
		for (int i=k; i<nums.length; i++) {
			int sum = prefix[i+1]-prefixMin[i-k];
			if (sum>=0) return true;
		}
		
		return false;
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
