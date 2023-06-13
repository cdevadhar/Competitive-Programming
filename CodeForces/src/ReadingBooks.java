import java.io.*;
import java.util.*;
public class ReadingBooks {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		long[] arr = new long[n];
		long sum=0;
		for (int i=0; i<n; i++) {
			arr[i] = in.nextLong();
			sum+=arr[i];
		}
		Arrays.parallelSort(arr);
		if (arr[n-1]>(sum-arr[n-1])) {
			System.out.println(2*arr[n-1]);
		}
		else System.out.println(sum);
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(new InputStreamReader(System.in));
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
