import java.io.*;
import java.util.*;
public class TwoPlatforms {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int k = in.nextInt();
			Integer[] points = new Integer[n];
			int[] suffixPlatform = new int[n+1];
			for (int i=0; i<n; i++) {
				points[i] = in.nextInt();
			}
			for (int i=0; i<n; i++) in.nextInt();
			Arrays.parallelSort(points);
			for (int i=n-1; i>=0; i--) {
				int right = binarySearch(points, points[i]+k);
				int covered=(right-i+1);
				suffixPlatform[i] = Math.max(covered, suffixPlatform[i+1]);
			}
			int ans=0;
			for (int i=0; i<n; i++) {
				int right = binarySearch(points, points[i]+k);
				int covered=(right-i+1);
				ans = Math.max(ans, covered+suffixPlatform[right+1]);
			}
			System.out.println(ans);
		}
	}
	public static int binarySearch(Integer[] points, Integer right) {
		int hi=points.length-1;
		int lo=0;
		while (hi>lo) {
			int mid=(hi+lo+1)/2;
			if (points[mid]<=right) lo=mid;
			else hi=mid-1;
		}
		return hi;
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    public FastIO() throws IOException
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
