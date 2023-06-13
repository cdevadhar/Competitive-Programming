import java.io.*;
import java.util.*;
// Figure out tomorrow
public class SymmetricArray {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			long[] d = new long[2*n];
			for (int i=0; i<2*n; i++) {
				d[i] = in.nextLong();
			}
			Arrays.sort(d);
			boolean works = true;
			HashMap<Long, Integer> occurences = new HashMap<Long, Integer>();
			for (int i=0; i<2*n; i+=2) {
				if (d[i]!=d[i+1]) {
					works = false;
					System.out.println("failed1");
				}
				if (d[i]%2!=0) {
					works = false;
					System.out.println("failed2");
				}
				occurences.putIfAbsent(d[i], 0);
				occurences.put(d[i], occurences.get(d[i]+1));
			}
			Set<Long> keys = occurences.keySet();
			long[] b = new long[n];
			int j=0;
			for (Long key: keys) {
				if (occurences.get(key)!= null && occurences.get(key)!=2) {
					works = false;
					System.out.println("failed " + key + occurences.get(key));
				}
				b[j] = key;
				j++;
			}
			if (!works) {
				System.out.println("NO");
				continue;
			}
			else {
				boolean ans = true;
				long sum=0;
				Arrays.sort(b);
				for (int i=n-1; i>=0; i--) {
					if (b[i]>0 && b[i]%(2*(i+1))==0) {
						sum+=2*(b[i]/(2*(i+1)));
					}
					else {
						ans = false;
						break;
					}
				}
				if (ans) System.out.println("YES");
				else System.out.println("NO");
				
			}
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
