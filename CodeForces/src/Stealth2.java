import java.io.*;
import java.util.*;

public class Stealth2 {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		long k = in.nextLong();
		Long[] nums = new Long[n];
		for (int i=0; i<n; i++) {
			nums[i] = in.nextLong();
		}
		Arrays.parallelSort(nums);
		if (k==1) {
			System.out.println(2*nums[n-1]);
		}
		else {
			int lo = 0;
			int hi = n-1;
			while (hi>lo) {
				int mid = (hi+lo)/2;
				long leftOver = k-((long)(n-mid))*((long)(n-mid));
				if (leftOver<0) lo = mid+1;
				else {
					if (doesWork(nums, mid, leftOver)) hi = mid;
					else lo = mid+1;
				}
			}
			int index = hi;
			long leftOver = k-((long)(n-index))*((long)(n-index));
			for (int i=index; i<n; i++) {
				
			}
		}
	}
	public static boolean doesWork(Long[] nums, int index, long leftover) {
		
		long val = nums[index]*2;
		int pairs = 0;
		int lowerIndex = 0;
		for (int higherIndex = index+1; higherIndex<nums.length; higherIndex++) {
			while (lowerIndex<index && nums[lowerIndex]+nums[higherIndex]<val) {
				lowerIndex++;
			}
			pairs+=index-lowerIndex;
		}
		return pairs<=leftover;
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
