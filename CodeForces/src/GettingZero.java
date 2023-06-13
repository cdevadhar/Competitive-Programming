import java.io.*;
import java.util.*;

public class GettingZero {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		for (int tc=0; tc<n; tc++) {
			int curr = in.nextInt();
			int min = 15;
			for (int additions = 0; additions<15; additions++) {
				min = Math.min(min, additions+check(curr+additions));
			}
			System.out.print(min+" ");
		}
	}
	public static int check(int num) {
		int count = 0;
		while ((num%32768)!=0) {
			num = (num*2)%32768;
			count++;
		}
		return count;
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(
	           new InputStreamReader(System.in));
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
