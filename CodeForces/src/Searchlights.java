import java.io.*;
import java.util.*;
public class Searchlights {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] robbers = new int[n][2];
		int[][] searchlights = new int[m][2];
		for (int i=0; i<n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			robbers[i][0] = x;
			robbers[i][1] = y;
		}
		for (int i=0; i<m; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			searchlights[i][0] = x;
			searchlights[i][1] = y;
		}
		int[] minY = new int[1000001];
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (robbers[i][0]<=searchlights[j][0]) minY[searchlights[j][0]-robbers[i][0]] = Math.max(minY[searchlights[j][0]-robbers[i][0]], searchlights[j][1]-robbers[i][1]+1);
			}
		}
		for (int i=999999; i>=0; i--) {
			minY[i] = Math.max(minY[i], minY[i+1]);
			
		}
		int min = Integer.MAX_VALUE;
		for (int i=0; i<minY.length; i++) {
			min = Math.min(min, i+minY[i]);
		}
		System.out.println(min);
	}
	
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(new InputStreamReader(System.in));
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
