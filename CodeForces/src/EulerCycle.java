import java.io.*;
import java.util.*;
public class EulerCycle {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			long n = in.nextLong();
			long l = in.nextLong()-1;
			long r = in.nextLong()-1;
			long pairs = n-1;
			long total = 0;
			int start = 1;
			while (total+pairs*2<l && total+1<l) {
				total+=pairs*2;
				pairs-=1;
				start++;
			}
			if (start==n) {
				System.out.println(1);
				continue;
			}
			long index = total;
//			System.out.println(start);
			while (index<=r) {
				if (start==n) {
					System.out.print(1);
					break;
				}
				for (int i=0; i<pairs*2; i++) {
					int curr = 0;
					if (i%2==0) curr = start;
					else curr = (i+3)/2 + start-1;
					if (index>r) break;
					if (index>=l) System.out.print(curr+" ");
					index++;
				}
				start++;
				pairs--;
			}
			System.out.println();
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
