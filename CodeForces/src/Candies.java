import java.io.*;
import java.util.*;
public class Candies {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] a = new int[n];
			for (int i=0; i<n; i++) {
				a[i] = in.nextInt();
			}
			int alice = a[0];
			int bob = 0;
			int moves = 1;
			int left = 1;
			int right = n-1;
			
			int prev = a[0];
			int  curr = 1;
			while (right>=left) {
				
				if (curr==1) {
					int total = 0;
					while (total<=prev && right>=left) {
						total+=a[right];
						right--;
					}
					bob+=total;
					prev = total;
				}
				else {
					int total = 0;
					while (total<=prev && right>=left) {
						total+=a[left];
						left++;
					}
					alice+=total;
					prev = total;
				}
//				System.out.println(alice+" "+bob+" "+left+" "+right);
				curr = 1-curr;
				moves++;
				
			}
			System.out.println(moves+" "+alice+" "+bob);
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
