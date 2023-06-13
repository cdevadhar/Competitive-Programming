import java.io.*;
import java.util.*;

public class Triangles {
	static int mod = 1000000007;
	static int n;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("triangles.in", "triangles.out");
		n = in.nextInt();
		HashMap<Integer, ArrayList<Point>> sortX = new HashMap<Integer, ArrayList<Point>>();
		HashMap<Integer, ArrayList<Point>> sortY = new HashMap<Integer, ArrayList<Point>>();
		for (int i=0; i<n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			Point px = new Point(x, y, i);
			Point py = new Point(x, y, i);
			sortX.putIfAbsent(x, new ArrayList<Point>());
			sortX.get(x).add(px);
			sortY.putIfAbsent(y, new ArrayList<Point>());
			sortY.get(y).add(py);
		}
		long[] xDistance = new long[n];
		long[] yDistance = new long[n];
		Set<Integer> xCoors = sortX.keySet();
		for (Integer x: xCoors) {
			
			ArrayList<Point> curr = sortX.get(x);
//			System.out.println(x+" "+curr.size());
			Point[] currArray = new Point[curr.size()];
			for (int i=0; i<curr.size(); i++) {
				currArray[i] = curr.get(i);
			}
			Arrays.sort(currArray, (o1, o2) -> Integer.compare(o1.y, o2.y));
			int[] prefix = new int[currArray.length+1];
			for (int i=0; i<currArray.length; i++) {
				prefix[i+1] = prefix[i]+currArray[i].y;
			}
			for (int i=0; i<currArray.length; i++) {
				int leftSum = i*currArray[i].y-prefix[i];
				int rightSum = (prefix[currArray.length]-prefix[i+1])-(currArray.length-i-1)*currArray[i].y;
//				System.out.println("X: " + currArray[i].id + " " + leftSum + " " + rightSum);
				xDistance[currArray[i].id] = leftSum+rightSum;
			}
		}
		Set<Integer> yCoors = sortY.keySet();
		for (Integer y: yCoors) {
			ArrayList<Point> curr = sortY.get(y);
//			System.out.println(y+" "+curr.size());
			Point[] currArray = new Point[curr.size()];
			for (int i=0; i<curr.size(); i++) {
				currArray[i] = curr.get(i);
			}
			Arrays.sort(currArray, (o1, o2) -> Integer.compare(o1.x, o2.x));
			int[] prefix = new int[currArray.length+1];
			for (int i=0; i<currArray.length; i++) {
				prefix[i+1] = prefix[i]+currArray[i].x;
			}
			for (int i=0; i<currArray.length; i++) {
				int leftSum = i*currArray[i].x-prefix[i];
				int rightSum = (prefix[currArray.length]-prefix[i+1])-(currArray.length-i-1)*currArray[i].x;
				yDistance[currArray[i].id] = leftSum+rightSum;
			}
		}
		long ans = 0;
		for (int i=0; i<n; i++) {
//			System.out.println(i+" "+xDistance[i]+" "+yDistance[i]);
			ans+=(xDistance[i]*yDistance[i])%mod;
		}
//		System.out.println(ans%mod);
		in.pr.println(ans%mod);
		in.pr.close();
	}
	static class Point {
		int x, y, id;
		public Point(int x, int y, int id) {
			this.x = x;
			this.y = y;
			this.id = id;
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