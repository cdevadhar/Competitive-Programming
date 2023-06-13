import java.io.*;
import java.util.*;
public class Forgetful {
	//Implement dp later
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			Sequence[][] length2 = new Sequence[10][10];
			Sequence[][][] length3 = new Sequence[10][10][10];
			for (int i=0; i<n; i++) {
				String s = in.next();
				for (int j=0; j<m-1; j++) {
					length2[s.charAt(j)-'0'][s.charAt(j+1)-'0'] = new Sequence(j, j+1, i+1);
				}
				for (int j=0; j<m-2; j++) {
					length3[s.charAt(j)-'0'][s.charAt(j+1)-'0'][s.charAt(j+2)-'0'] = new Sequence(j, j+2, i+1);
				}
			}
			String number = in.next();
			
		}
	}
	static class Sequence {
		int l, r, id;
		public Sequence(int l, int r, int id) {
			this.l = l;
			this.r = r;
			this.id = id;
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
