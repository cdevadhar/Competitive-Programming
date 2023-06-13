import java.io.*;
import java.util.*;
public class MixingWater {
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			int h = in.nextInt();
			int c = in.nextInt();
			int desired = in.nextInt();
			double average = (double)(h+c)/2;
			if (desired<=average) System.out.println(2);
			else if (desired>=h) System.out.println(1);
			else {
				int y1 = (h-desired)/(2*desired-h-c);
				int y2 = y1+1;
//				System.out.println(y1+" "+y2);
				int ans1 = Math.abs((desired*(2*y1+1)-((y1+1)*h + y1*c))*(2*y2+1));
				int ans2 = Math.abs((desired*(2*y2+1)-((y2+1)*h + (y2)*c))*(2*y1+1));
//				System.out.println(ans1+" "+ans2);
				if (ans1<=ans2) {
					System.out.println(2*y1+1);
				}
				else {
					System.out.println(2*y2+1);
				}
			}
			
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
