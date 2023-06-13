import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Ladder {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int m = in.nextInt();
		int[] nums = new int[n];
		int[] nonDecreasing = new int[n];
		int[] nonIncreasing = new int[n];
		for (int i=0; i<n; i++) {
			nums[i] = in.nextInt();
			
		}
		nonDecreasing[0] = 0;
		nonIncreasing[0] = 0;
		for (int i=1; i<n; i++) {
			if (nums[i]>=nums[i-1]) {
				nonDecreasing[i] = nonDecreasing[i-1]+1;
			}
			else {
				nonDecreasing[i] = 0;
			}
			if (nums[i]<=nums[i-1]) {
				nonIncreasing[i] = nonIncreasing[i-1]+1;
			}
			else {
				nonIncreasing[i] = 0;
			}
		}
		for (int i=0; i<m; i++) {
			int l = in.nextInt()-1;
			int r = in.nextInt()-1;
			if (r-nonIncreasing[r]<=l) System.out.println("Yes");
			else if (r-nonDecreasing[r]<=l) System.out.println("Yes");
			else {
				int switchPoint = r-nonIncreasing[r];
				if (switchPoint-nonDecreasing[switchPoint]<=l) System.out.println("Yes");
				else System.out.println("No");
			}
		}
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
