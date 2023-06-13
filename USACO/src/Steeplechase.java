import java.io.*;
import java.util.*;
public class Steeplechase {
	static int n;
	static Line[] lines;
	static int[] intersections;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("USACOinput1", "cowjump.out");
		n = in.nextInt();
		lines = new Line[n];
		intersections = new int[n];
		for (int i=0; i<n; i++) {
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			if (x1<x2) {
				lines[i] = new Line(x1, y1, x2, y2);
			}
			else {
				lines[i] = new Line(x2, y2, x1, y1);
			}
		}
		int maxIntersections = 0;
		int bestIndex = 0;
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
//				System.out.println(i + " " + j + " " + doIntersect(lines[i], lines[j]));
				if (doIntersect(lines[i], lines[j])) {
					intersections[i]++;
					intersections[j]++;
				}
				if (intersections[i]>maxIntersections) {
					bestIndex = i;
					maxIntersections = intersections[i];
				}
				if (intersections[i]==maxIntersections) {
					if (i<bestIndex) bestIndex = i;
				}
				if (intersections[j]>maxIntersections) {
					bestIndex = j;
					maxIntersections = intersections[j];
				}
				if (intersections[j]==maxIntersections) {
					if (j<bestIndex) bestIndex = j;
				}
			}
		}
		System.out.println(bestIndex+1);
		
	}
	
	public static boolean doIntersect(Line l1, Line l2) {
		if (l1.x1>l2.x2 || l2.x1>l1.x2) return false;
		
		int start = Math.max(l1.x1, l2.x1);
		int end = Math.min(l1.x2, l2.x2);
		double startDiff = (l1.slope*l1.x1+l1.yInt)-(l2.slope*l2.x1+l2.yInt);
		double endDiff =  (l1.slope*l1.x2+l1.yInt)-(l2.slope*l2.x2+l2.yInt);
		if (startDiff==0 || endDiff==0) return true;
		if (startDiff<0 && endDiff>0) return true;
		if (startDiff>0 && endDiff<0) return true;
		return false;
	}
	static class Line {
		int x1, y1, x2, y2;
		double slope, yInt;
		public Line(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
			this.slope = (double)(y2-y1)/(x2-x1);
			this.yInt = y1-slope*x1;
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
