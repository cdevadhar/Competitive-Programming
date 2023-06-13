import java.io.*;
import java.util.*;
public class Garland {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		String garland = in.next();
		int[][] occurences = new int[n+1][26];
		for (int i=0; i<n; i++) {
			char c = garland.charAt(i);
			for (int j=0; j<26; j++) {
				occurences[i+1][j] = occurences[i][j];
			}
			occurences[i+1][c-'a']++;
		}
//		
		int[][] ans = new int[n+1][26];
		for (int curr=0; curr<26; curr++) {
			char c = (char) ('a'+curr);
//			System.out.println(c);
			for (int start=0; start<n; start++) {
				for (int end=start; end<n; end++) {
					int occ = occurences[end+1][curr]-occurences[start][curr];
					int adding = (end-start+1)-occ;
					ans[adding][curr] = Math.max(ans[adding][curr], (end-start+1));
//					System.out.println((occ));
				}
			}
			int max = ans[0][curr];
			for (int i=0; i<n+1; i++) {
				max = Math.max(max, ans[i][curr]);
				ans[i][curr] = max;
			}
		}
		
		int q = in.nextInt();
		for (int i=0; i<q; i++) {
			int m = in.nextInt();
			char c = in.next().charAt(0);
			System.out.println(ans[m][c-'a']);
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
