import java.io.*;
import java.util.*;
public class Medians2 {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int k = in.nextInt();
			boolean found = false;
			int[] nums = new int[n];
			for (int i=0; i<n; i++) {
				int x = in.nextInt();
				nums[i] = x;
				
				if (x==k) found = true;
			}
			if (!found) {
				System.out.println("NO");
				continue;
			}
			// Check if k is the median of any subarray
			int[] b = new int[n];
			for (int i=0; i<n; i++) {
				if (nums[i]<k) b[i] = -1;
				else if (nums[i]==k) b[i] = 0;
				else b[i] = 1;
			}
			boolean works = false;
			if (n==1) works = true;
			for (int i=0; i<n; i++) {
				for (int j=i+1; j<n && j-i<=2; j++) {
					if (b[i]>=0 && b[j]>=0) works = true;
				}
			}
			if (works) System.out.println("YES");
			else System.out.println("NO");
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
