import java.io.*;
import java.util.*;
public class BAString {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int k = in.nextInt();
			long x = in.nextLong()-1;
			String s = in.next();
			ArrayList<Integer> segments = new ArrayList<Integer>();
			int streak = 0;
			for (int i=0; i<n; i++) {
				if (s.charAt(i)=='a' && streak>0) {
					
					segments.add(streak);
					streak=0;
					continue;
				}
				if (s.charAt(i)=='*') streak++;
				
			}
			if (streak>0) segments.add(streak);
//			for (int i=0; i<segments.size(); i++) {
//				in.pr.println(segments.get(i));
//			}
			
			ArrayList<Long> ans = new ArrayList<Long>();
			for (int i=segments.size()-1; i>=0; i--) {
//				in.pr.println(k*segments.get(i)+1);
				long numBs = (x)%(k*segments.get(i)+1);
				x/=(k*segments.get(i)+1);
				ans.add(numBs);
//				in.pr.println(numBs);
			}
			int prev = 0;
			int index = segments.size()-1;
			for (int i=0; i<n; i++) {
				if (s.charAt(i)=='a') {
					in.pr.print('a');
					prev = 0;
				}
				else {
					if (prev==0) {
						for (int j=0; j<ans.get(index); j++) {
							in.pr.print('b');
						}
						prev = 1;
						index--;
					}
					else continue;
				}
			}
			in.pr.println();
		}
		in.pr.close();
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
