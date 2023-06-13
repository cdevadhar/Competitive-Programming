import java.io.*;
import java.util.*;
public class Segments {
	// Come back to this tomorrow
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			Segment[] segments = new Segment[n];
			Integer[] starts = new Integer[n];
			Integer[] ends = new Integer[n];
			for (int i=0; i<n; i++) {
				int start = in.nextInt();
				int end = in.nextInt();
				Segment s = new Segment(start, end);
				segments[i] = s;
				starts[i] = start;
				ends[i] = end;
			}
			Arrays.sort(starts);
			Arrays.sort(ends);
			long ans = Integer.MAX_VALUE;
			for (int i=0; i<n; i++) {
				int endBefore = binarySearch(ends, segments[i].start);
				int startAfter = binarySearch2(starts, segments[i].end);
//				System.out.println(endBefore+1+" "+(n-startAfter));
				ans = Math.min(ans, (endBefore+1)+(n-startAfter));
			}
			System.out.println(ans);
		}
	}
	// Finds the maximum index such that arr[index]<value
	public static int binarySearch(Integer[] arr, int value) {
		int hi = arr.length-1;
		int lo=0;
		while (hi>lo) {
			
			int mid = (hi+lo+1)/2;
//			System.out.println(arr[mid]);
			if (arr[mid]>=value) hi=mid-1;
			else lo=mid;
		}
		if (arr[hi]>=value) return hi-1;
		
		return hi;
	}
	// Minimum index such that arr[index]>value
	public static int binarySearch2(Integer[] arr, int value) {
		int hi = arr.length-1;
		int lo=0;
		while (hi>lo) {
			int mid = (hi+lo)/2;
			if (arr[mid]<=value) lo=mid+1;
			else hi=mid;
		}
		if (arr[hi]<=value) return hi+1;
		return hi;
	}
	static class Segment {
		int start, end;
		public Segment(int start, int end) {
			this.start = start;
			this.end = end;
		}
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
