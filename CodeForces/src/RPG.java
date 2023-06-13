import java.io.*;
import java.util.*;

public class RPG {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int p = in.nextInt();
			int f = in.nextInt();
			int numS = in.nextInt();
			int numA = in.nextInt();
			int weightS = in.nextInt();
			int weightA = in.nextInt();
			int ans=0;
			for (int swords=0; swords<=numS; swords++) {
				if (swords*weightS>p) break;
				int axes = Math.min(numA, (p-swords*weightS)/weightA);
//				System.out.println(swords+" "+axes);
				if (weightS<weightA) {
					int remainingSwords = numS-swords;
					int partnerSwords = Math.min(remainingSwords, f/weightS);
					int leftoverStorage = f-(partnerSwords*weightS);
					int remainingAxes = numA-axes;
					int partnerAxes = Math.min(remainingAxes, leftoverStorage/weightA);
					ans = Math.max(ans, swords+axes+partnerSwords+partnerAxes);
				}
				else {
					int remainingAxes = numA-axes;
					int partnerAxes = Math.min(remainingAxes, f/weightA);
					int leftoverStorage = f-(partnerAxes*weightA);
					int remainingSwords = numS-swords;
					int partnerSwords = Math.min(remainingSwords, leftoverStorage/weightS);
					ans = Math.max(ans, swords+axes+partnerAxes+partnerSwords);
				}
				
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
