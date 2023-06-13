import java.io.*;
import java.util.*;
public class Pond {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int k = in.nextInt();
		int[][] grid = new int[n][n];
		int[] nums = new int[n*n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				grid[i][j] = in.nextInt();
				nums[i*n+j] = grid[i][j];
			}
		}
		Arrays.sort(nums);
		int hi = n*n-1;
		int lo = 0;
		while (hi>lo) {
			int mid = (hi+lo)/2;
			if (doesWork(grid, nums[mid], n, k)) hi = mid;
			else lo = mid+1;
		}
		System.out.println(nums[hi]);
	}
	public static boolean doesWork(int[][] grid, int median, int n, int k) {
		int numBigger = (k*k)/2;
		int[][] temp = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (grid[i][j]>=median) temp[i][j] = 1;
			}
		}
		int[][] prefix = new int[n+1][n+1];
		int[][] occPrefix = new int[n+1][n+1];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				prefix[i+1][j+1] = prefix[i][j+1]+prefix[i+1][j]-prefix[i][j]+temp[i][j];
				occPrefix[i+1][j+1] = occPrefix[i][j+1]+occPrefix[i+1][j]-occPrefix[i][j];
				if (grid[i][j]==median) occPrefix[i+1][j+1]++;
			}
		}
//		for (int i=0; i<n+1; i++) {
//			for (int j=0; j<n+1; j++) {
//				System.out.print(prefix[i][j]+" ");
//			}
//			System.out.println();
//		}
		for (int i=0; i<=n-k; i++) {
			for (int j=0; j<=n-k; j++) {
				int sum = prefix[i+k][j+k]-prefix[i+k][j]-prefix[i][j+k]+prefix[i][j];
				int occ = occPrefix[i+k][j+k]-occPrefix[i+k][j]-occPrefix[i][j+k]+occPrefix[i][j];
//				System.out.println(sum);
				if (occ>0) sum--;
				if (sum<=numBigger) return true;
			}
		}
		return false;
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
