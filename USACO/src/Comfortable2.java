import java.io.*;
import java.util.*;
public class Comfortable2 {
	static boolean[][] cows;
	static boolean[][] adjacent;
	static boolean[][] visited;
	static int n;
	static Queue<Cow> queue;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		n = in.nextInt();
		cows = new boolean[2010][2010];
		queue = new LinkedList<Cow>();
		int totalCows = 0;
		for (int i=1; i<=n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			queue.add(new Cow(x+502, y+502));
			
			while (!queue.isEmpty()) {
				Cow curr = queue.poll();
				if (cows[curr.x][curr.y]) continue;
				cows[curr.x][curr.y] = true;
				totalCows++;
				comfortable(curr.x, curr.y);
				comfortable(curr.x+1, curr.y);
				comfortable(curr.x-1, curr.y);
				comfortable(curr.x, curr.y+1);
				comfortable(curr.x, curr.y-1);
			}
			System.out.println(totalCows-i);
		}
	}
	
	public static void add(int x, int y) {
		
	}
	//If a cow is comfortable, returns a cow that needs to be added to make it uncomfortable. Otherwise, returns a cow with integer_max x and y
	public static void comfortable(int x, int y) {
		if (!cows[x][y]) return;
		if (cows[x+1][y] && cows[x-1][y] && cows[x][y+1] && !cows[x][y-1]) queue.add(new Cow(x, y-1));
		if (cows[x+1][y] && cows[x-1][y] && !cows[x][y+1] && cows[x][y-1]) queue.add(new Cow(x, y+1));
		if (!cows[x+1][y] && cows[x-1][y] && cows[x][y+1] && cows[x][y-1]) queue.add(new Cow(x+1, y));
		if (cows[x+1][y] && !cows[x-1][y] && cows[x][y+1] && cows[x][y-1]) queue.add(new Cow(x-1, y));

	}
	static class Cow {
		@Override
		public int hashCode() {
			return x;
		}
		@Override
		public boolean equals(Object other) {
			return ((Cow)other).x==x && ((Cow)other).y==y;
		}
		int x, y;
		public Cow(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;

	    public FastIO()
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