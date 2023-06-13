import java.io.*;
import java.util.*;
public class CowCross2 {
	static int n, k, b;
	public static void main(String[] args)  throws Exception{
		FastIO in = new FastIO("USACOinput1", "maxcross.out");
		n = in.nextInt();
		k = in.nextInt();
		b = in.nextInt();
		boolean[] broken = new boolean[n];
		int[] prefix = new int[n+1];
		for (int i=0; i<b; i++) {
			broken[in.nextInt()-1] = true;
		}
		prefix[0] = 0;
		for (int i=1; i<n+1; i++) {
			prefix[i] = prefix[i-1];
			if (!broken[i-1]) prefix[i]++;
		}
		int max = 0;
//		for (int i=0; i<n; i++) {
//			System.out.println(prefix[i]);
//		}
		for (int i=k-1; i<n; i++) {
//			System.out.println(prefix[i+1]-prefix[i-(k-1)]);
			if (prefix[i+1]-prefix[i-(k-1)]>max) max = prefix[i+1]-prefix[i-(k-1)];
		}
		System.out.println(k-max);
		
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO(String fileIn, String fileOut) throws IOException {
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