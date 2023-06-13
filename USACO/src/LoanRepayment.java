import java.io.*;
import java.util.*;
public class LoanRepayment {
	static long n, k, m;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("loan.in", "loan.out");
		n = in.nextLong();
		k = in.nextLong();
		m = in.nextLong();
		long high = 1000000000000L;
		long low = 0;
		while (high>low) {
//			System.out.println(high);
			long mid = (high+low+1)/2;
			if (doesWork(mid)) {
				low = mid;
			}
			else high = mid-1;
		}
		in.pr.println(high);
		in.pr.close();
	}
	public static boolean doesWork(long x) {
		long g = 0;
		long count=0;
		while (g<n && count<k) {
			long amount = (n-g)/x;
			if (amount<m) {
				long left = (long)Math.ceil((double)(n-g)/m);
				return count+left<=k;
			}
			long min = amount*x;
			long days = Math.min((n-g-min)/amount + 1, k);
			g+=days*amount;
			count+=days;
		}
		return g>=n;
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
