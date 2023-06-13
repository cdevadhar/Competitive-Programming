import java.io.*;
import java.util.*;
public class DecreaseSet {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int testcase=0; testcase<t; testcase++) {
			int n = in.nextInt();
			long k = in.nextInt();
			long[] nums = new long[n];
			long[] prefix = new long[n];
			long minValue = Integer.MAX_VALUE;
			int numMins = 0;
			int count = 0;
			long sum = 0;
			for (int i=0; i<n; i++) {
				nums[i] = in.nextLong();
				minValue = Math.min(minValue, nums[i]);
				sum+=nums[i];
				
			}
			
			Arrays.sort(nums);
			
			for (int i=1; i<n; i++) {
				prefix[i] = nums[i]+prefix[i-1];
			}
			long min = Integer.MAX_VALUE;
			for (int y=0; y<n; y++) {
				long unsetSum = prefix[n-1-y];
				long minimum = (k-unsetSum)/(y+1);
				long reductionsNeeded = Math.max(0, minValue-minimum);
				min = Math.min(min, y+reductionsNeeded);
//				System.out.println(y + " " + reductionsNeeded);
			}
			System.out.println(min);
		}
	}
	public static int reduce(long[] nums, long min, long sum, long k) {
		int count=0;
		
		for (int i=nums.length-1; i>0; i--) {
			sum-=(nums[i]-min);
			count++;
			if (sum<=k) {
				return count;
			}
		}
		return Integer.MAX_VALUE;
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
