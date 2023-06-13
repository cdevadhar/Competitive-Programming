import java.io.*;
import java.util.*;

public class GoodSubarrays {

	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			int n = in.nextInt();
			String s = in.next();
			long[] prefix = new long[s.length()+1];
			long ans = 0;

			HashMap<Long, Long> map = new HashMap<Long, Long>();
			map.put(0L, 1L);
			for (int j=0; j<s.length(); j++) {
				int curr = s.charAt(j)-'0';
//				System.out.println(curr);
				prefix[j+1] = prefix[j]+curr;
//				System.out.print(prefix[j+1]);
				if (map.containsKey(prefix[j+1]-(j+1))) {
//					System.out.println("added1");
					map.put(prefix[j+1]-(j+1), map.get(prefix[j+1]-(j+1))+1);
				}
				else {
//					System.out.println("added2");
					map.put(prefix[j+1]-(j+1), 1L);
				}
			}
			Set<Long> keys = map.keySet();
			for (Long key: keys) {
//				System.out.println(key + " " + map.get(key));
				ans+=(map.get(key)*(map.get(key)-1)/2);
			}
			System.out.println(ans);
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
