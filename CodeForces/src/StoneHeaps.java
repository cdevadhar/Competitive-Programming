import java.io.*;
import java.util.*;
public class StoneHeaps {
	
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int testcase=0; testcase<t; testcase++) {
			int n = in.nextInt();
			int[] heaps = new int[n];
			for (int i=0; i<n; i++) heaps[i] = in.nextInt();
			int high = 1000000000;
			int low = 0;
			while (high>low) {
				int mid = (high+low+1)/2;
				int[] temp = heaps.clone();
				if (canGet(mid, temp, heaps)) {
					low = mid;
				}
				else high = mid-1;
			}
			System.out.println(high);
		}
		
	}
	public static boolean canGet(int minHeap, int[] heaps, int[] original) {
		for (int i=heaps.length-1; i>=2; i--) {
			int d = (int)(Math.min(original[i], heaps[i]-minHeap)/3);
			if (d<0) d=0;
			heaps[i-2]+=2*d;
			heaps[i-1]+=d;
			heaps[i]-=3*d;
		}
		for (int i=0; i<heaps.length; i++) {
			if (heaps[i]<minHeap) return false;
		}
		return true;
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
