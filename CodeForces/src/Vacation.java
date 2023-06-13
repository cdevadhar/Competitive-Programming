import java.io.*;
import java.util.*;
public class Vacation {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int x = in.nextInt();
		int[] months = new int[2*n];
		int[] prefix = new int[2*n+1];
		int[] prefixHugs = new int[2*n+1];
		for (int i=0; i<n; i++) {
			months[i] = in.nextInt();
			months[i+n] = months[i];
		}
		for (int i=0; i<2*n; i++) {
			prefix[i+1] = prefix[i]+months[i];
			prefixHugs[i+1] = prefixHugs[i]+(months[i]*(months[i]+1)/2);
		}
		int ans = 0;
		for (int endMonth = n; endMonth<2*n; endMonth++) {
			int endDay = prefix[endMonth+1];
			int startDay = endDay-x;
			int firstMonth = binarySearch(prefix, startDay);
			System.out.println(endMonth+" "+firstMonth);
			int firstMonthDays = prefix[firstMonth]-startDay;
			int start = months[firstMonth-1]-firstMonthDays;
			int firstMonthHugs = months[firstMonth-1]*(months[firstMonth-1]+1)/2 -start*(start+1)/2;
			int otherHugs = prefix[endMonth+1]-prefix[firstMonth];
			ans = Math.max(ans, firstMonthHugs+otherHugs);
		}
		System.out.println(ans);
	}
	// Finds the month that includes the start date (the earliest with prefix>days)
	public static int binarySearch(int[] prefix, int days) {
		int hi = prefix.length-1;
		int lo = 0;
		while (hi>lo) {
			int mid = (hi+lo)/2;
			if (prefix[mid]>days) hi = mid;
			else lo = mid+1;
		}
		return hi;
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
