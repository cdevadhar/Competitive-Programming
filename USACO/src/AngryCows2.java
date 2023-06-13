import java.io.*;
import java.util.*;
public class AngryCows2 {
	static int n, k;
	static int[] haybales;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		n = in.nextInt();
		k = in.nextInt();
		haybales = new int[n];
		for (int i=0; i<n; i++) {
			haybales[i] = in.nextInt();
		}
		Arrays.parallelSort(haybales);
		int high=Integer.MAX_VALUE;
		int low=0;
		while(high>low) {
			int mid = (high+low)/2;
			if (canDetonate(mid)) {
				high=mid;
			}
			else {
				low=mid+1;
			}
		}
		System.out.println(low);
	}
	
	public static boolean canDetonate(int radius) {
		int index = 1;
		int cowCount=1;
		int currentBlast=0;
		while (index<n) {
			if (cowCount>k) return false;
			currentBlast+=haybales[index]-haybales[index-1];
			if (currentBlast>2*radius) {
				cowCount++;
				currentBlast=0;
				index++;
			}
			else {
				index++;
			}
		}
		if (cowCount>k) return false;
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
