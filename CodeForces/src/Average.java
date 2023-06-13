import java.io.*;
import java.util.*;
public class Average {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] a = new int[n];
			for (int i=0; i<n; i++) {
				a[i] = in.nextInt();
			}
			int x = in.nextInt();
			for (int i=0; i<n; i++) {
				a[i]-=x;
			}
			boolean[] used = new boolean[n];
			Arrays.fill(used, true);
			int count = n;
			for (int i=1; i<n; i++) {
				if (a[i]+a[i-1]<0 && used[i-1]) {
					used[i] = false;
					count--;
				}
				else if (i>1 && a[i]+a[i-1]+a[i-2]<0 && used[i-1] && used[i-2]) {
					used[i] = false;
					count--;
				}
			}
			System.out.println(count);
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
