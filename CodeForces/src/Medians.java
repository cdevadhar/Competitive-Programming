import java.io.*;
import java.util.*;
public class Medians {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] b = new int[n];
			for (int i=0; i<n; i++) {
				b[i] = in.nextInt();
			}
			TreeSet<Integer> a = new TreeSet<Integer>();
			a.add(b[0]);
			int median = b[0];
			boolean works = true;
			for (int i=1; i<n; i++) {
				if (a.higher(median)==null && a.lower(median)==null) {
					if (b[i]==median) {
						a.add(Integer.MIN_VALUE);
						a.add(Integer.MAX_VALUE);
					}
					else if (b[i]>median) {
						a.add(b[i]);
						a.add(Integer.MAX_VALUE);
					}
					else {
						a.add(b[i]);
						a.add(Integer.MIN_VALUE);
					}
					median = b[i];
					continue;
				}
				int lower = a.lower(median);
				int higher = a.higher(median);
				if (b[i]<lower || b[i]>higher) {
					works = false;
					break;
				}
				if (b[i]==median) {
					a.add(Integer.MIN_VALUE);
					a.add(Integer.MAX_VALUE);
				}
				else if (b[i]>median) {
					a.add(b[i]);
					a.add(Integer.MAX_VALUE);
				}
				else {
					a.add(b[i]);
					a.add(Integer.MIN_VALUE);
				}
				median = b[i];

			}
			if (works) System.out.println("YES");
			else System.out.println("NO");
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
