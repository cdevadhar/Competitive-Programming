import java.util.*;
import java.io.*;
public class MountainView {
	static int n;
	static ArrayList<Mountain> mountains;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO("USACOinput1", "mountains.out");
		n = in.nextInt();
		mountains = new ArrayList<Mountain>();
		for (int i=0; i<n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int leftBase = x-y;
			int rightBase = x+y;
			Mountain m = new Mountain(x, y, leftBase, rightBase);
			mountains.add(m);
		}
		Collections.sort(mountains);
		int maxRight = 0;
		int count=0;
		for (Mountain m: mountains) {
			if (m.rightBase>maxRight) {
				count++;
				maxRight = m.rightBase;
			}
			
		}
		System.out.println(count);
	}
	
	static class Mountain implements Comparable<Mountain> {
		int peakX, peakY, leftBase, rightBase;
		public Mountain(int peakX, int peakY, int leftBase, int rightBase) {
			this.peakY = peakY;
			this.peakX = peakX;
			this.leftBase = leftBase;
			this.rightBase = rightBase;
		}
		@Override
		public int compareTo(Mountain o) {
			// TODO Auto-generated method stub
			if (leftBase==o.leftBase) {
				return Integer.compare(o.peakY, peakY);
			}
			return Integer.compare(leftBase, o.leftBase);
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
