import java.io.*;
import java.util.*;


public class EqualMod {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			boolean has0=false, has1 = false;
			for (int i=0; i<n; i++) {
				arr[i] = in.nextInt();
				if (arr[i]==1) has1 = true;
				else if (arr[i]==0) has0 = true;
			}
			if (!has1) System.out.println("YES");
			else {
				Arrays.parallelSort(arr);
				boolean works = true;
				for (int i=0; i<n-1; i++) {
					if (arr[i]==arr[i+1]-1) {
						works = false;
					}
				}
				if (works) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
	
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(
	           new InputStreamReader(System.in));
	        pr = new PrintWriter(System.out);
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
