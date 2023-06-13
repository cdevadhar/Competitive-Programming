import java.io.*;
import java.util.*;
public class Subtraction {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] nums = new int[n];
			int[] decreasing = new int[n];
			int[] increasing = new int[n];
			for (int i=0; i<n; i++) {
				nums[i] = in.nextInt();
			}
			decreasing[0] = nums[0];
			increasing[0] = 0;
			boolean works = true;
			for (int i=1; i<n; i++) {
				decreasing[i] = Math.min(decreasing[i-1], nums[i]-increasing[i-1]);
				increasing[i] = nums[i]-decreasing[i];
//				System.out.println(decreasing[i]+" "+increasing[i]);
				if (increasing[i]<increasing[i-1]) works = false;
				if (decreasing[i]<0) works = false;
			}
			if (works) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(new InputStreamReader(System.in));
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
