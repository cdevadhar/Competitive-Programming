import java.io.*;
import java.util.*;
public class PrefixFlip {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			String start = in.next();
			String target = in.next();
			
			ArrayList<Integer> flipsA = new ArrayList<Integer>();
			ArrayList<Integer> flipsB = new ArrayList<Integer>();
			for (int i=0; i<start.length()-1; i++) {
				if (start.charAt(i)!=start.charAt(i+1)) {
					flipsA.add(i);
				}
			}
			if (start.charAt(start.length()-1)=='1') flipsA.add(start.length()-1);
			for (int i=0; i<target.length()-1; i++) {
				if (target.charAt(i)!=target.charAt(i+1)) {
					flipsB.add(i);
				}
			}
			if (target.charAt(n-1)=='1') flipsB.add(n-1);
			Collections.reverse(flipsB);
			System.out.print(flipsA.size()+flipsB.size()+" ");
			for (int i=0; i<flipsA.size(); i++) {
				System.out.print(flipsA.get(i)+1+" ");
			}
			for (int i=0; i<flipsB.size(); i++) {
				System.out.print(flipsB.get(i)+1+" ");
			}
			System.out.println();
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(
	           new InputStreamReader(System.in));

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
