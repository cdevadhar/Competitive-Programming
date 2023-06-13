import java.io.*;
import java.util.*;
// revisit this
public class Integral {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int c = in.nextInt();
			int[] occ = new int[c+1];
			int[] occPrefix = new int[c+1];
			int[] a = new int[n];
			for (int i=0; i<n; i++) {
				a[i] = in.nextInt();
				occ[a[i]]++;
			}
			for (int i=0; i<c; i++) {
				occPrefix[i+1] = occPrefix[i]+occ[i+1];
			}
			Arrays.parallelSort(a);
			boolean works = true;
			for (int r=1; r<=c; r++) {
				
				if (Arrays.binarySearch(a, r)>=0) continue;
//				System.out.println(r);
				for (int y=0; y<n; y++) {
					if (r*a[y]>c) break;
					int lower = r*a[y]-1;
					int upper = Math.min(c, (r+1)*a[y]-1);
//					System.out.println("test");
					if (occPrefix[upper]-occPrefix[lower]>0) {
						works = false;
						break;
					}
				}
			}
			if (works) System.out.println("YES");
			else System.out.println("NO");
		}
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
