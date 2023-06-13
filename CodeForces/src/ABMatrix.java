import java.io.*;
import java.util.*;
public class ABMatrix {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			if (n*a!=m*b) {
				in.pr.println("NO");
				continue;
			}
			in.pr.println("YES");
			int[][] ans = new int[n][m];
			int start=0;
			for (int row=0; row<n; row++) {
				int count=0;
				int index=start;
				while (count<a) {
					ans[row][index] = 1;
					index = (index+1)%m;
					count++;
				}
				start = (start+a)%m;
			}
			for (int i=0; i<n; i++) {
				for (int j=0; j<m; j++) {
					in.pr.print(ans[i][j]);
				}
				in.pr.println();
			}
		}
		in.pr.close();
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(new InputStreamReader(System.in));
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
