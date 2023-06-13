import java.io.*;
import java.util.*;

public class Sabotage {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("sabotage.in", "sabotage.out");
		int n = in.nextInt();
		int[] production = new int[n];
		for (int i=0; i<n; i++) {
			production[i] = in.nextInt();
		}
		double lo = 1;
		double hi = 10000000.0;
		while (round3(lo)!=round3(hi)) {
			double mid = (hi+lo)/2;
			if (works(production, n, mid)) hi = mid;
			else lo = mid;
		}
		in.pr.printf("%.3f", lo);
		in.pr.close();
	}
	public static boolean works(int[] production, int n, double b) {
		double best, cur;
		int total = 0;
		// total unmodified sum
		for (int i=0; i<n; i++) total+=production[i];
		// storing the best possible modified sum
		best = cur = production[1]-b;
		for (int i=2; i<n-1; i++) {
			if (cur<0) cur = 0;
			cur+=production[i]-b;
			if (cur>best) best = cur;
		}
		// best is the largest modified sum, what is total - b*n
		// total - b*n would be the modified sum
		// basically modified sum - best subsequence sum has to be <= 0
		// that would make the average less than or equal to b
		return best >= total-b*n;
	}
	public static int round3(double b) {
		return (int)(1000*b + 0.5);
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO(String fileIn, String fileOut) throws IOException
	    {
	        br = new BufferedReader(
	            new FileReader(fileIn));
	        pr = new PrintWriter(new BufferedWriter(new FileWriter(fileOut)));
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
