import java.io.*;
import java.util.*;
public class NoPalindromes {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int m = in.nextInt();
		String s = in.next();
		int[][] prefix = new int[6][n+1];
		char[] a1 = {'a','b','c'};
		char[] a2 = {'a','c','b'};
		char[] a3 = {'b','a','c'};
		char[] a4 = {'b','c','a'};
		char[] a5 = {'c','b','a'};
		char[] a6 = {'c','a','b'};
		fillPrefix(prefix, 0, a1, n, s);
		fillPrefix(prefix, 1, a2, n, s);
		fillPrefix(prefix, 2, a3, n, s);
		fillPrefix(prefix, 3, a4, n, s);
		fillPrefix(prefix, 4, a5, n, s);
		fillPrefix(prefix, 5, a6, n, s);

		for (int i=0; i<m; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			int min = Integer.MAX_VALUE;
			for (int j=0; j<6; j++) {
				min = Math.min(min,prefix[j][end]-prefix[j][start-1]);
			}
			System.out.println(min);
		}
	}
	public static void fillPrefix(int[][] prefix, int row, char[] perm, int n, String s) {
		for (int i=0; i<n; i++) {
			prefix[row][i+1] = prefix[row][i];
			if (s.charAt(i)!=perm[i%3]) {
				prefix[row][i+1]++;
			}
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
