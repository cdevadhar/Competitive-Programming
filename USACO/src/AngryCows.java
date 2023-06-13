import java.io.*;
import java.util.*;

public class AngryCows {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("USACOinput1", "angry.out");
		int n = in.nextInt();
		int[] haybales = new int[n];
		for (int i=0; i<n; i++) {
			haybales[i] = in.nextInt();
		}
		Arrays.parallelSort(haybales);
		int[] minLeft = new int[n];
		int[] minRight = new int[n];
		minLeft[0] = 0;
		minRight[n-1] = 0;
		for (int i=1; i<n; i++) {
			minLeft[i] = Math.max(haybales[i]-haybales[i-1], minLeft[i-1]+1);
			System.out.println(minLeft[i]);
		}
		for (int i=n-2; i>=0; i--) {
			minRight[i] = Math.max(haybales[i]-haybales[i+1], minRight[i+1]+1);
			System.out.println(minRight[i]);
		}
		double ans = Math.min(minLeft[n-1], minRight[0]);
		System.out.println(ans);
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO(String fileIn, String fileOut) throws IOException
	    {
	        br = new BufferedReader(
	            new FileReader(fileIn));
	        pr = new PrintWriter(new BufferedWriter(new FileWriter(fileOut)));
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