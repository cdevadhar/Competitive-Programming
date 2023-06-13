import java.util.*;
import java.io.*;
public class Acowdemia2 {
	static long n, k, l;
	static long[] papers;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		n = in.nextLong();
		k = in.nextLong();
		l = in.nextLong();
		papers = new long[(int)n];
		for (int i=0; i<n; i++) {
			papers[i] = in.nextInt();
		}
		Arrays.parallelSort(papers);
		int high=100000;
		int low=0;
		while(high>low) {
			int mid = (high+low+1)/2;
			if (canReach(mid)) low=mid;
			else high=mid-1;
		}
		System.out.println(low);
//		for (int i=1; i<100; i++) {
//			if (!canReach(i)) {
//				System.out.println(i-1);
//				break;
//			}
//		}
	}
	
	public static boolean canReach(int hIndex) {
		if (hIndex>n) return false;
		int startIndex = (int) n-hIndex;
		long totalCitationsNeeded = 0;
		for (int i=startIndex; i<n; i++) {
			if (papers[i]+k<hIndex) return false;
			totalCitationsNeeded+=Math.max(0,(hIndex-papers[i]));
		}
		if (totalCitationsNeeded>k*l) return false;
		return true;
		
	}
	
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;

	    public FastIO()
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
