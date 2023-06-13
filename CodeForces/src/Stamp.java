import java.io.*;
import java.util.*;
public class Stamp {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			char[] s = in.next().toCharArray();
			ArrayList<Character> compressed = new ArrayList<Character>();
			char prev = s[0];
			compressed.add(prev);
			for (int i=1; i<n; i++) {
//				System.out.println(s[i]+" "+prev);
				if (s[i]!=prev) {
					compressed.add(s[i]);
//					System.out.println("added");
				}
				prev = s[i];
			}
			boolean works = true;
			for (int i=0; i<compressed.size(); i++) {
//				System.out.print(compressed.get(i));
				if (compressed.get(i)=='B') {
					int count = 0;
					if (i>0 && compressed.get(i-1)=='R') count++;
					if (i<compressed.size()-1 && compressed.get(i+1)=='R') count++;
					if (count<1) {
						works = false;
						break;
					}
				}
				if (compressed.get(i)=='R') {
					int count = 0;
					if (i>0 && compressed.get(i-1)=='B') count++;
					if (i<compressed.size()-1 && compressed.get(i+1)=='B') count++;
					if (count<1) {
						works = false;
						break;
					}
				}
			}
			if (works) System.out.println("YES");
			else System.out.println("NO");
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
