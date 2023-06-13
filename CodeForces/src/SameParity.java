import java.io.*;
import java.util.*;
public class SameParity {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int k = in.nextInt();
			
			int oddMax = n-(k-1);
			if (oddMax>0 && oddMax%2==1) {
				System.out.println("YES");
				System.out.print(oddMax+" ");
				for (int i=0; i<k-1; i++) System.out.print(1+" ");
				System.out.println();
				continue;
			}
			int evenMax = n-2*(k-1);
			if (evenMax>0 && evenMax%2==0) {
				System.out.println("YES");
				System.out.print(evenMax+" ");
				for (int i=0; i<k-1; i++) System.out.print(2+" ");
				System.out.println();
				continue;
			}
			System.out.println("NO");
		}
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
