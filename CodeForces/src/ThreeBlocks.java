import java.io.*;
import java.util.*;
public class ThreeBlocks {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] a = new int[n];
			
			ArrayList<Integer>[] positions = new ArrayList[200];
			for (int i=0; i<200; i++) {
				positions[i] = new ArrayList<Integer>();
			}
			int[][] prefix = new int[n+1][200];
			for (int i=0; i<n; i++) {
				a[i] = in.nextInt()-1;
				for (int j=0; j<200; j++) {
					prefix[i+1][j] = prefix[i][j];
				}
				prefix[i+1][a[i]]++;
				positions[a[i]].add(i);
			}
			int maxAns = 0;
			for (int i=0; i<200; i++) {
				maxAns = Math.max(maxAns, prefix[n][i]);
			}
			for (int i=0; i<200; i++) {
				if (positions[i].size()==0) continue;
//				System.out.println(positions[i].size());
				int hi = positions[i].size()-1;
				int lo = 0;
				while (hi>lo) {
					int maxB = 0;
					
					for (int j=0; j<200; j++) {
						maxB = Math.max(maxB, prefix[positions[i].get(hi)][j]-prefix[positions[i].get(lo)+1][j]);
					}
//					System.out.println(hi+" "+lo+" "+maxAns);
					maxAns = Math.max(maxAns, (lo+1)+(positions[i].size()-hi)+maxB);
					hi--;
					lo++;
				}
			}
			System.out.println(maxAns);
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
