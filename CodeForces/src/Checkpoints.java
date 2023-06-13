import java.io.*;
import java.util.*;
public class Checkpoints {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			long k = in.nextLong();
			if (k%2==1) {
				System.out.println(-1);
			}
			else {
				solve(k);
			}
		}
	}
	public static void solve(long k) {
		Queue<Integer> ans = new LinkedList<Integer>();
		long curr=2;
		long count = 1;
		while (2*(curr+1)<=k) {
			curr = (curr+1)*2;
			count++;
		}
		while (k>0) {
			k-=curr;
			ans.add(1);
			for (int i=1; i<count; i++) {
				ans.add(0);
			}
			while (k<curr) {
				curr = (curr/2)-1;
				count--;
			}
		}
		System.out.println(ans.size());
		while (!ans.isEmpty()) {
			System.out.print(ans.poll()+" ");
		}
		System.out.println();
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
