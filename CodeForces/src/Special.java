import java.io.*;
import java.util.*;
public class Special {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] a = new int[n];
			int[] p = new int[n+1];
			for (int i=0; i<n; i++) {
				a[i] = in.nextInt();
				p[i+1] = a[i]+p[i];
			}
			boolean[] works = new boolean[n+1];
			for (int i=0; i<n-1; i++) {
				for (int j=i+2; j<=n; j++) {
					
					int sum = p[j]-p[i];
//					System.out.println("Sum "+ sum);
					if (sum<=n) works[sum] = true;
				}
			}
			int sum=0;
			for (int i: a) if (works[i]) sum++;
			System.out.println(sum);
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
