import java.io.*;
import java.util.*;
public class Intervals {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int m = in.nextInt();
		int[] occStart = new int[m+1];
		int[] occEnd = new int[m+1];
		int[] winStart = new int[2*m+1];
		int[] winEnd = new int[2*m+1];
		
		for (int i=0; i<n; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			occStart[start]++;
			occEnd[end]++;
		}
		for (int i=0; i<=m; i++) {
			for (int j=0; j<=m; j++) {
				winStart[i+j]+=(occStart[i]*occStart[j]);
				winEnd[i+j]+=(occEnd[i]*occEnd[j]);
			}
		}
		
		long currAns = 0;
		for (int i=0; i<2*m+1; i++) {
			currAns+=winStart[i];
			System.out.println(currAns);
			currAns-=winEnd[i];
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