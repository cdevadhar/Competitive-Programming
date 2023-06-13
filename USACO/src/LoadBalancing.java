import java.io.*;
import java.util.*;
public class LoadBalancing {
	static int n;
	static Cow[] sortX, sortY;
	public static void main(String[] args) throws IOException {
		FastIO in = new FastIO("USACOinput1", "balancing.out");
		n = in.nextInt();
		sortX = new Cow[n];
		sortY = new Cow[n];
		for (int i=0; i<n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			sortX[i] = new Cow(x, y);
			sortY[i] = new Cow(x, y);
		}
		Arrays.sort(sortX, (o1, o2) -> {
			if (o1.x==o2.x) return Integer.compare(o1.y, o2.y);
			return Integer.compare(o1.x, o2.x);
		});
		Arrays.sort(sortY, (o1, o2) -> {
			if (o1.y==o2.y) return Integer.compare(o1.x, o2.x);
			return Integer.compare(o1.y, o2.y);
		});
		int index=0;
		while (index<n) {
			if (index<n-1 && sortX[index].x==sortX[index+1].x) {
				index++; 
				continue;
			}
			
		}
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
