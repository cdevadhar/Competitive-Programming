import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Robot {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			int n = in.nextInt();
			int m = in.nextInt();
			String directions = in.next();
			int currX=0, currY=0;
			int minX=0, maxX=0, minY=0, maxY=0;
			int ansX=0, ansY=0;
			for (int j=0; j<directions.length(); j++) {
				if (directions.charAt(j)=='R') currX++;
				if (directions.charAt(j)=='L') currX--;
				if (directions.charAt(j)=='U') currY++;
				if (directions.charAt(j)=='D') currY--;
				minX = Math.min(minX, currX);
				maxX = Math.max(maxX, currX);
				minY = Math.min(minY,  currY);
				maxY = Math.max(maxY, currY);
				System.out.println(minX+" "+maxX+" "+minY+" "+maxY);
				if (maxY-minY+1>n) break;
				if (maxX-minX+1>m) break;
				ansX = maxY;
				ansY = m-maxX-1;
			}
			System.out.println((ansX+1)+" "+(ansY+1));
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
