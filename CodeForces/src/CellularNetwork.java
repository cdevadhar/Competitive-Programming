import java.io.*;
import java.util.*;

public class CellularNetwork {
	static int n, m;
	static int[] towers, cities;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		n = in.nextInt();
		m = in.nextInt();
		cities = new int[n];
		towers = new int[n];
		for (int i=0; i<n; i++) {
			cities[i] = in.nextInt();
		}
		for (int i=0; i<m; i++) {
			towers[i] = in.nextInt();
		}
		int maxDistance = 0;
		Arrays.parallelSort(cities);
		Arrays.parallelSort(towers);
		for (int i=0; i<n; i++) {
			int right = Arrays.binarySearch(towers, cities[i]);
			if (right<0) right = -1*right+1;
			maxDistance = Math.max(maxDistance, towers[right]-cities[right]);
			maxDistance = Math.max(maxDistance, cities[i]-towers[right-1]);
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
