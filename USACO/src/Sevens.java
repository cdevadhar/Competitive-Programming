import java.io.*;
import java.util.*;
public class Sevens {
	static int n;
	static int[] prefix;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		n = in.nextInt();
		prefix = new int[n+1];
		for (int i=1; i<=n; i++) {
			prefix[i] = prefix[i-1] + in.nextInt();
			prefix[i]%=7;
		}
		int max=0;
		for (int i=0; i<7; i++) {
			int maxRegion = 0;
			int minOccurence=0;
			int maxOccurence=0;
			for (int j=0; j<=n; j++) {
				if (prefix[j]==i) {
					minOccurence=j;
					break;
				}
			}
			for (int j=n; j>=0; j--) {
				if (prefix[j]==i) {
					maxOccurence=j;
					break;
				}
			}
			maxRegion = maxOccurence-minOccurence;
			if (maxRegion>max) max = maxRegion;
		}
		System.out.println(max);
	}
	
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;

	    public FastIO()
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