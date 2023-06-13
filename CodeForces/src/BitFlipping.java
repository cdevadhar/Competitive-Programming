import java.io.*;
import java.util.*;
public class BitFlipping {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int k = in.nextInt();
			char[] bits = in.next().toCharArray();
//			in.pr.println(bits.toString());
			int[] ans = new int[n];
			if (k%2==1) {
				for (int i=0; i<n; i++) {
					if (bits[i]=='0') bits[i] = '1';
					else bits[i] = '0';
				}
			}
			for (int i=0; i<n-1; i++) {
				if (k==0) break;
				if (bits[i]=='0') {
					bits[i] = '1';
					k--;
					ans[i]++;
				}
			}
			if (k>0) {
				if (k%2==1) {
					if (bits[n-1]=='1') {
						bits[n-1] = '0';
					}
					else bits[n-1] = '1';
				}
				ans[n-1]=k;
				
			}
			for (int i=0; i<n; i++) in.pr.print(bits[i]);
			in.pr.println();
			for (int i=0; i<n; i++) in.pr.print(ans[i]+" ");
			in.pr.println();
			
		}
		in.pr.close();
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
