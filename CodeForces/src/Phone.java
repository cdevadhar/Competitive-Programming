import java.io.*;
import java.util.*;
public class Phone {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[][] applications = new int[n][2];
			int important = 0;
			for (int i=0; i<n; i++) {
				applications[i][0] = in.nextInt();
			}
			for (int i=0; i<n; i++) {
				applications[i][1] = in.nextInt();
				if (applications[i][1]==2) {
					important++;
				}
			}
			int[] goodApps = new int[important];
			int[] badApps = new int[n-important];
			int goodIndex=0, badIndex=0;
			for (int i=0; i<n; i++) {
				if (applications[i][1]==1) {
					badApps[badIndex] = applications[i][0];
					badIndex++;
				}
				else {
					goodApps[goodIndex] = applications[i][0];
					goodIndex++;
				}
			}
			Arrays.sort(goodApps);
			Arrays.sort(badApps);
			for (int i=0; i<goodApps.length/2; i++) {
				int temp = goodApps[i];
				goodApps[i] = goodApps[goodApps.length-i-1];
				goodApps[goodApps.length-i-1] = temp;
			}
			for (int i=0; i<badApps.length/2; i++) {
				int temp = badApps[i];
				badApps[i] = badApps[badApps.length-i-1];
				badApps[badApps.length-i-1] = temp;
			}
			int[] goodPrefix = new int[important+1];
			int[] badPrefix = new int[n-important+1];
			for (int i=0; i<goodApps.length; i++) {
				goodPrefix[i+1] = goodPrefix[i]+goodApps[i];
			}
			for (int i=0; i<badApps.length; i++) {
				badPrefix[i+1] = badPrefix[i]+badApps[i];
			}
			long ans = Integer.MAX_VALUE;
			for (int x=0; x<=n-important; x++) {
				int index = Arrays.binarySearch(goodPrefix, m-badPrefix[x]);
				if (index<0) {
					index++;
					index*=(-1);
				}
				
				if (index<important+1) {
					ans = Math.min(ans, index*2 + x);
				}
				
			}
			if (ans==Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(ans);
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
