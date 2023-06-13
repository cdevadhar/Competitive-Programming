import java.io.*;
import java.util.*;
public class Brackets {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
	
		int n = in.nextInt();
		int[] compressed = new int[n];
		int[] open = new int[n+1];
		for (int i=0; i<n; i++) {
			compressed[i] = in.nextInt();
			if (i%2==0) {
				open[i+1] = open[i]+compressed[i];
			}
			else {
				open[i+1] = open[i]-compressed[i];
			}
			System.out.println(open[i+1]);
		}
		long ans=0;
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				if (i%2 ==1 || j%2 == 0) continue;
				System.out.println(open[j]+" "+open[i+1]);
				int between = open[j]-open[i+1];
				System.out.println(i+" "+j+" "+between);
				if (between<0) {
					int minOpen = (-1)*between;
					if (minOpen>compressed[i]) continue;
					ans+=(Math.min(compressed[i]-minOpen, compressed[j]));
					System.out.println((Math.min(compressed[i]-minOpen, compressed[j])));
				}
				else {
					int minClosed = between;
					if (minClosed>compressed[j]) continue;
					ans+=Math.min(compressed[j]-minClosed, compressed[i]);
					System.out.println(Math.min(compressed[j]-minClosed, compressed[i]));
				}
			}
		}
		System.out.println(ans);
		
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
