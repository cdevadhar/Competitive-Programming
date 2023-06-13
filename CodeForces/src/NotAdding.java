import java.io.*;
import java.util.*;
public class NotAdding {
	public static int gcd(int a, int b) {
		if (b==0) return a;
		return gcd(b, a%b);
	}
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int[] arr = new int[n];
		int[] exists = new int[1000001];
		for (int i=0; i<n; i++) {
			arr[i] = in.nextInt();
			exists[arr[i]] = 1;
		}
		int ans = 0;
		for (int i=1; i<1000001; i++) {
			int gcd = 0;
			for (int j=i; j<1000001; j+=i) {
				if (exists[j]>0) gcd = gcd(gcd, j);
			}
			if (gcd==i) {
				exists[i] = 1;
				ans++;
			}
		}
		System.out.println(ans-n);
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
