import java.io.*;
import java.util.*;
public class Hexagons {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			long x2 = in.nextInt();
			long y2 = in.nextInt();
			long[] cost = new long[6];
			for (int i=0; i<6; i++) {
				cost[i] = in.nextInt();
			}
			long[] betterCost = new long[6];
			betterCost[0] = Math.min(cost[0], cost[1]+cost[5]);
			betterCost[1] = Math.min(cost[1], cost[0]+cost[2]);
			betterCost[2] = Math.min(cost[2], cost[1]+cost[3]);
			betterCost[3] = Math.min(cost[3], cost[2]+cost[4]);
			betterCost[4] = Math.min(cost[4], cost[3]+cost[5]);
			betterCost[5] = Math.min(cost[5], cost[4]+cost[0]);
			
			long ans = 0;
			if (x2>=0 && y2>=0) {
				long min = Math.min(x2, y2);
				ans+=min*betterCost[0];
				x2-=min;
				y2-=min;
				if (x2>0) ans+=x2*betterCost[5];
				if (y2>0) ans+=y2*betterCost[1];
			}
			else if (x2>=0 && y2<=0) {
				y2 = -y2;
				ans+=x2*betterCost[5];
				ans+=y2*betterCost[4];
			}
			else if (x2<=0 && y2<=0) {
				y2 = -y2;
				x2 = -x2;
				long min = Math.min(x2, y2);
				ans+=min*betterCost[3];
				x2-=min;
				y2-=min;
				if (x2>0) ans+=x2*betterCost[5];
				if (y2>0) ans+=y2*betterCost[1];
			}
			else if (x2<=0 && y2>=0) {
				x2 = -x2;
				ans+=x2*betterCost[2];
				ans+=y2*betterCost[1];
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
