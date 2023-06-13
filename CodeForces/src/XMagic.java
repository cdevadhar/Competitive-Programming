import java.util.*;
import java.io.*;
public class XMagic {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			long a = in.nextLong();
			long b = in.nextLong();
			long x = in.nextLong();
			if (Math.max(a, b)<x) {
				System.out.println("NO");
			}
			else {
				boolean ans = check(a, b, x);
				if (ans) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
	public static boolean check(long a, long b, long x) {
		if (a==x || b==x) return true;
		if (b>a) {
			long temp=a;
			a=b;
			b=temp;
		}
		if (b>a-b) b = a-b;
		if (x>Math.max(a, b) || a==0 || b==0) return false;
		long numSkipped = Math.max(1L, (a-Math.max(x, b))/(2*b));
		return check(a-b*numSkipped, b, x);
		
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
