import java.io.*;
import java.util.*;
public class SleepyCowHerding {
	
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("USACOinput1", "herding.out");
		int n = in.nextInt();
		int[] cows = new int[n];
		for (int i=0; i<n; i++) {
			cows[i] = in.nextInt();
			
		}
		Arrays.parallelSort(cows);
		int min = getMin(cows);
		int leftGap = cows[1]-cows[0]-1;
		int rightGap = cows[n-1]-cows[n-2]-1;
		int numGaps = (cows[n-1]-cows[0]+1)-n;
//		System.out.println(numGaps);
		int max = numGaps-Math.min(leftGap, rightGap);
		System.out.println(min);
		System.out.println(max);
	}
	public static int getMin(int[] cows) {
		int n = cows.length;
		if (cows[1]-cows[0]>1 && cows[n-1]-cows[1]==n-2) return 2;
		if (cows[n-1]-cows[n-2]>1 && cows[n-2]-cows[0]==n-2) return 2;
		int j=0;
		int best=0;
		for (int i=0; i<n; i++) {
			while (j<n-1 && cows[j+1]-cows[i]<=n-1) j++;
			best = Math.max(best, j-i+1);
		}
		return n-best;
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO(String fileIn, String fileOut) throws IOException
	    {
	        br = new BufferedReader(
	            new FileReader(fileIn));
	        pr = new PrintWriter(new BufferedWriter(new FileWriter(fileOut)));
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
