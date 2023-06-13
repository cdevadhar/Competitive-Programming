import java.io.*;
import java.util.*;
public class ThreeBags {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int[] n = new int[3];
		for (int i=0; i<3; i++) n[i] = in.nextInt();
		long[] min = new long[3];
		long[] sum = new long[3];
		Arrays.fill(min, Integer.MAX_VALUE);
		for (int i=0; i<3; i++) {
			for (int j=0; j<n[i]; j++) {
				long x = in.nextInt();
				min[i] = Math.min(min[i], x);
				sum[i]+=x;
			}
		}
		Arrays.parallelSort(min);
		System.out.println((sum[0]+sum[1]+sum[2])-2*(Math.min(sum[0], Math.min(sum[1], Math.min(sum[2], min[0]+min[1])))));
		
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
