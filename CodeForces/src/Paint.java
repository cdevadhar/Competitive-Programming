import java.io.*;
import java.util.*;

public class Paint {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int[] a = new int[n];
		int[] closest = new int[n];
		int[] position = new int[n];
		for (int i=0; i<n; i++) {
			a[i] = in.nextInt()-1;
		}
		Arrays.fill(position, n+1);
		for (int i=1; i>=0; i--) {
			closest[i] = position[a[i]];
			position[a[i]] = i;
		}
		int lastW = 0;
		int lastB = 0;
		int segments = 0;
		for (int i=0; i<n; i++) {
			if (a[i]!=a[lastW] && a[i]==a[lastB]) {
				lastW = i;
				segments++;
			}
			else if (a[i]!=a[lastB] && a[i]==a[lastW]) {
				lastB = i;
				segments++;
			}
			else if (closest[lastW]<closest[lastB]) {
				lastW = i;
				segments++;
				
			}
			else {
				lastB = i;
				segments++;
			}
			
		}
		System.out.println(segments);
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
