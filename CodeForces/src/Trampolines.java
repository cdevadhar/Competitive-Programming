import java.io.*;
import java.util.*;
public class Trampolines {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			long[] strength = new long[n];
			long passes = 0;
			for (int i=0; i<n; i++) {
				strength[i] = in.nextInt();
				
			}
			boolean done = false;
			long[] numPekoras = new long[n+5];
			for (int i=0; i<n; i++) {
				long temp = numPekoras[i];
				if (temp<strength[i]) {
					passes+=(strength[i]-temp-1);
					temp +=(strength[i]-temp-1);
				}
				numPekoras[i+1]+=temp-strength[i]+1;
				for (int j=i+2; j<Math.min(n, i+strength[i]+1); j++) {
					numPekoras[j]++;
				}
			}
		
			System.out.println(passes);
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
