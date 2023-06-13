import java.io.*;
import java.util.*;
public class Hiking {

	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			int n = in.nextInt();
			int[] roads = new int[n];
			for (int j=0; j<n; j++) {
				roads[j] = in.nextInt(); 
			}
			boolean canReach = false;
			if (roads[0] == 1) {
				System.out.print(n+1 + " ");
				for (int j=1; j<n+1; j++) {
					System.out.print(j + " ");
				}
				System.out.println();
				continue;
			}
			if (roads[n-1] == 0) {
				
				for (int j=1; j<=n+1; j++) {
					System.out.print(j + " ");
				}
				System.out.println();
				continue;
			}
			for (int j=0; j<n; j++) {
				if ((j<n-1 && roads[j]==0 && roads[j+1]==1)) {
					canReach = true;
					for (int k=0; k<j; k++) {
						System.out.print(k+1 + " ");
					}
					System.out.print(n+1 + " ");
					for (int k=j; k<n; k++) {
						System.out.print(k+1 + " ");
					}
					System.out.println();
				}
			}
			
			if (!canReach) System.out.println(-1);
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
