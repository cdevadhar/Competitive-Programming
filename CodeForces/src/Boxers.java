import java.io.*;
import java.util.*;
public class Boxers {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int[] weights = new int[n];
		for (int i=0; i<n; i++) {
			weights[i] = in.nextInt();
		}
		Arrays.parallelSort(weights);
		int previousWeight = 0;
		int size = 1;
		if (weights[0]>1) previousWeight = weights[0]-1;
		else previousWeight = weights[0];
		for (int i=1; i<n; i++) {
			if (weights[i]-1>previousWeight) {
				size++;
				previousWeight=weights[i]-1;
			}
			else if (weights[i]>previousWeight) {
				size++;
				previousWeight=weights[i];
			}
			else if (weights[i]+1>previousWeight) {
				size++;
				previousWeight=weights[i]+1;
			}
		}
		System.out.println(size);
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
