import java.io.*;
import java.util.*;

public class Rectangles {
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO();
		int q = in.nextInt();
		
		for (int i=0; i<q; i++) {
			int n = in.nextInt();
			ArrayList<Integer> sticks = new ArrayList<Integer>();
			for (int j=0; j<4*n; j++) {
				int num = in.nextInt();
					sticks.add(num);
			}
		
			Collections.sort(sticks);
			boolean sameArea = true;
			int front = 0;
			int back = sticks.size()-1;
			int area = 0;
			while (back>front) {
				if (area>0) {
					
					int currArea = sticks.get(back)*sticks.get(front);
					if (currArea!=area) {
						sameArea = false;
						break;
					}
				}
				else {
					
					area = sticks.get(back)*sticks.get(front);
				}
				back-=2;
				front+=2;
			}
			if (sameArea) System.out.println("YES");
			else System.out.println("NO");
		
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
