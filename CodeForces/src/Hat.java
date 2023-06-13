import java.io.*;
import java.util.*;
public class Hat {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			int a = n/m;
			int b = (n+m-1)/m;
			int start = 0;
			int prevEnd = 0;
			for (int i=0; i<k; i++) {
				start = (prevEnd)%n;
				for (int j=0; j<n%m; j++) {
					System.out.print(b+" ");
					for (int x=0; x<b; x++) {
						System.out.print(start+1+" ");
						start = (start+1)%n;
					}
					System.out.println();
				}
				prevEnd = start;
				int temp = start;
				for (int j=0; j<m-n%m; j++) {
					System.out.print(a+" ");
					for (int x=0; x<a; x++) {
						System.out.print(temp+1+" ");
						temp = (temp+1)%n;
					}
					System.out.println();
				}
			}
			System.out.println();
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
