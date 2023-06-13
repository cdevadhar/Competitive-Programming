import java.io.*;
import java.util.*;

//NEEDS TO BE FINISHED

public class SwapSort {
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			int n = in.nextInt();
			int[] nums = new int[n];
			int numOdd = 0;
			for (int j=0; j<n; j++) {
				nums[j] = in.nextInt();
				if (nums[j]%2==1) numOdd++;
			}
			if (numOdd<(n-numOdd-1) || numOdd>(n-numOdd+1)) {
				System.out.println(-1);
				continue;
			}
			int pointer = 0;
			int case1 = 0;
			for (int j=0; j<n; j++) {
				
			}
			System.out.println(case1);
			
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
