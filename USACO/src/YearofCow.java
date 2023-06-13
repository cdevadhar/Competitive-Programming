import java.io.*;
import java.util.*;

public class YearofCow {
	static int n, k, numIntervals;
	static int[] ancestors, gaps;
	static HashMap<Integer, Integer> intervals;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		n = in.nextInt();
		k = in.nextInt();
		ancestors = new int[n];
		gaps = new int[n+1];
		intervals = new HashMap<Integer, Integer>();
		for (int i=0; i<n; i++) {
			int year = in.nextInt();
			ancestors[i] = (year/12)*12 + 12;
			if (intervals.containsKey(ancestors[i])) {
				intervals.put(ancestors[i], intervals.get(ancestors[i])+1);
			}
			else {
				numIntervals++;
				intervals.put(ancestors[i], 1);
			}
		}
		Arrays.parallelSort(ancestors);
		
		for (int i=0; i<n-1; i++) {
			gaps[i] = ancestors[i+1]-ancestors[i];
		}
		gaps[n-1] = ancestors[n-1];
		gaps[n] = ancestors[0]-12;
		Arrays.parallelSort(gaps);
		int sum=0;
		for (int i=0; i<numIntervals-k; i++) {
			sum+=gaps[i];
		}
		System.out.println(sum+12*numIntervals);
		
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