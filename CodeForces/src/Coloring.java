import java.io.*;
import java.util.*;

public class Coloring {
	public static void main(String[] args) throws Exception {
		
		FastIO in = new FastIO();
		int n = in.nextInt();
		int m = in.nextInt();
		long[] s = new long[m];
		long sum = 0;
		for (int i=0; i<m; i++) {
			s[i] = in.nextInt();
			sum+=s[i];
		}
		if (sum<n) {
			
			System.out.println(-1);
			return;
		}
		if ((n-s[m-1])<m-1) {
			System.out.println(-1);
			return;
		}
		ArrayList<Long> ans = new ArrayList<Long>();
		ans.add(n-s[m-1]+1);
		long prev = n-s[m-1]+1;
		boolean works = true;
		
		for (int i=m-2; i>=0; i--) {
			long spaces = prev-1;
			if (spaces-s[i]>=i) {
				ans.add(prev-s[i]);
				prev-=s[i];
			}
			// There are more spaces than operations to make, but this one is enough to overlap
			// So we should make it such that for the next i, spaces will be equal to i+1
			// prev-1 = i
			// prev = i+1
			else if (spaces>i+1) {
				if (i+s[i]>n) {
					System.out.println(-1);
					return;
				}
				ans.add((long) (i+1));
				prev = i+1;
			}
			else {
				if (prev-1+s[i]-1>n) {
					System.out.println(-1);
					return;
				}
				ans.add(--prev);
			}
		}
		for (int i=m-1; i>=0; i--) {
			System.out.print(ans.get(i)+" ");
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
