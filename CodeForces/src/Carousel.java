import java.io.*;
import java.util.*;
public class Carousel {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			int streak = -1;
			boolean hasDistinct = false;
			for (int i=0; i<n; i++) {
				arr[i] = in.nextInt();
				if (i>0 && arr[i]==arr[i-1]) streak = i-1;
				if (i>0 && arr[i]!=arr[i-1]) hasDistinct = true;
			}
			if (arr[n-1]==arr[0]) streak = n;
			if (!hasDistinct) {
				in.pr.println(1);
				for (int i=0; i<n; i++) {
					in.pr.print(1+" ");
				}
				in.pr.println();
			}
			else {
				if (n%2==0) {
					in.pr.println(2);
					for (int i=0; i<n; i++) {
						in.pr.print(i%2+1+" ");
					}
					in.pr.println();
				}
				else if (streak>=0) {
					in.pr.println(2);
					int prev = 1;
					for (int i=0; i<n; i++) {
						if (i==(streak+1)%n) {
							in.pr.print(prev+" ");
						}
						else in.pr.print(3-prev+" ");
						prev = 3-prev;
					}
					in.pr.println();
				}
				else {
					in.pr.println(3);
					for (int i=0; i<n-1; i++) {
						in.pr.print(i%2+1+" ");
					}
					in.pr.print(3+" ");
					in.pr.println();
				}
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
