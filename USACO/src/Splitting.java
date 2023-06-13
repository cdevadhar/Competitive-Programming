import java.io.*;
import java.util.*;

public class Splitting {
	static int n;
	static Cow[] cows;
	static int[][] prefixes;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO("split.in", "split.out");
		n = in.nextInt();
		cows = new Cow[n];
		prefixes = new int[n][4];
		for (int i=0; i<n; i++) {
			cows[i] = new Cow(in.nextInt(), in.nextInt());
		}
		Arrays.sort(cows, (o1, o2) -> {
			if (o1.x==o2.x) return Integer.compare(o1.y, o2.y);
			return Integer.compare(o1.x, o2.x);
		});
		prefixes[0][0] = cows[0].y;
		prefixes[0][1] = cows[0].y;
		prefixes[n-1][2] = cows[n-1].y;
		prefixes[n-1][3] = cows[n-1].y;
		
		for (int i=1; i<n; i++) {
			prefixes[i][0] = Math.max(prefixes[i-1][0], cows[i].y);
			prefixes[i][1] = Math.min(prefixes[i-1][1], cows[i].y);
		}
		for (int i=n-2; i>=0; i--) {
			prefixes[i][2] = Math.max(prefixes[i+1][2], cows[i].y);
			prefixes[i][3] = Math.min(prefixes[i+1][3], cows[i].y);
		}
		int area1 = (cows[n-1].x-cows[0].x)*(prefixes[n-1][0]-prefixes[n-1][1]);
		int maxSaved = 0;
		for (int i=0; i<n-1; i++) {
			int leftArea = (cows[i].x-cows[0].x)*(prefixes[i][0]-prefixes[i][1]);
			int rightArea = (cows[n-1].x-cows[i+1].x)*(prefixes[i+1][2]-prefixes[i+1][3]);
//			System.out.println(leftArea+rightArea);
			if (cows[i+1].x==cows[i].x && ((prefixes[i+1][2]<=prefixes[i][0] && prefixes[i+1][2]>=prefixes[i][1]) || (prefixes[i+1][3]<=prefixes[i][0] && prefixes[i+1][3]>=prefixes[i][1]))) continue;
			maxSaved = Math.max(maxSaved, area1-(leftArea+rightArea));
		}
		in.pr.println(maxSaved);
		in.pr.close();
	}
	
	static class Cow {
		int x, y;
		public Cow(int x, int y) {
			this.x = x;
			this.y = y;
		}
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
