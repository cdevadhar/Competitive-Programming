import java.io.*;
import java.util.*;
public class Hills {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] nums = new int[n];
			int[] state = new int[n];
			int hv=0;
			for (int i=0; i<n; i++) {
				nums[i] = in.nextInt();
			}
			for (int i=1; i<n-1; i++) {
				if (nums[i]>nums[i-1] && nums[i]>nums[i+1]) {
					state[i] = 1;
					hv++;
				}
				if (nums[i]<nums[i-1] && nums[i]<nums[i+1]) {
					state[i] = 2;
					hv++;
				}
			}
			int maxSaved=0;
			for (int i=1; i<n-1; i++) {
				int numSaved = 0;
				if (state[i-1]>0 && state[i+1]>0 && state[i]>0) {
					numSaved=3;
				}
				else {
					if (state[i-1]>0) numSaved++;
					if (state[i]>0) numSaved++;
					if (state[i+1]>0) numSaved++;
					
				}
				maxSaved = Math.max(maxSaved, numSaved);
				
			}
			System.out.println(hv-maxSaved);
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
