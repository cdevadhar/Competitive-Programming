import java.io.*;
import java.util.*;
public class Instructions {
	static int n, targetX, targetY;
	static int[] ans;
	static Pair[] pairs;
	static ArrayList<Sum> firstHalf, secondHalf;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		n = in.nextInt();
		ans = new int[n+1];
		pairs = new Pair[n];
		targetX = in.nextInt();
		targetY = in.nextInt();
		firstHalf = new ArrayList<Sum>();
		secondHalf = new ArrayList<Sum>();
		for (int i=0; i<n; i++) {
			pairs[i] = new Pair(in.nextInt(), in.nextInt());
		}
		dfs(0, 0, 0, 0, true, n/2 + 1);
		dfs(0, pairs[0].x, pairs[0].y, 1, true, n/2 + 1);
		dfs(n/2 + 1, 0, 0, 0, true, n);
		dfs(n/2 + 1, pairs[n/2 + 1].x, pairs[n/2 + 1].y, 1, true, n);
		Collections.sort(firstHalf, (o1, o2) -> {
			if (o1.xSum==o2.xSum) return Integer.compare(o1.ySum, o2.ySum);
			return Integer.compare(o1.xSum, o2.xSum);
		});
		Collections.sort(secondHalf, (o1, o2) -> {
			if (o1.xSum==o2.xSum) return Integer.compare(o1.ySum, o2.ySum);
			return Integer.compare(o1.xSum, o2.xSum);
		});
		int pointer1 = 0;
		int pointer2 = 0;
//		System.out.println(firstHalf.size()+" "+secondHalf.size());
		for (int i=0; i<firstHalf.size(); i++) {
			Pair p = xRange(secondHalf, targetX-firstHalf.get(i).xSum);
			if (firstHalf.get(i).xSum+secondHalf.get(p.x).xSum!=targetX) continue;
			int startY = findY(secondHalf, targetY-firstHalf.get(i).ySum, p.x, p.y);
			if (firstHalf.get(i).ySum+secondHalf.get(startY).ySum!=targetY) continue;
			for (int j=startY; j<=p.y; j++) {
				if (firstHalf.get(i).ySum+secondHalf.get(j).ySum==targetY) {
					ans[firstHalf.get(i).numIncluded+secondHalf.get(j).numIncluded]++;
				}
				if (firstHalf.get(i).ySum+secondHalf.get(j).ySum>targetY) {
					break;
				}
			}
		}
//		for (int i=0; i<firstHalf.size(); i++) {
//			for (int j=0; j<secondHalf.size(); j++) {
//				if (firstHalf.get(i).ySum+secondHalf.get(j).ySum==targetY && firstHalf.get(i).xSum+secondHalf.get(j).xSum==targetX) {
//					ans[firstHalf.get(i).numIncluded+secondHalf.get(j).numIncluded]++;
//				}
//			}
//		}
		for (int i=1; i<n+1; i++) {
			System.out.println(ans[i]);
		}
	}
	public static void dfs(int index, int xSum, int ySum, int numIncluded, boolean canChange, int upperBound) {
		if (index>=upperBound) return;
		if (upperBound==n/2 + 1 && canChange) {
			Sum s = new Sum(xSum, ySum, numIncluded);
			firstHalf.add(s);
		}
		else if (upperBound==n && canChange) {
			Sum s = new Sum(xSum, ySum, numIncluded);
			secondHalf.add(s);
		}
		if (index<n-1) {
			dfs(index+1, xSum, ySum, numIncluded, false, upperBound);
			dfs(index+1, xSum+pairs[index+1].x, ySum+pairs[index+1].y, numIncluded+1, true, upperBound);
		}
		
	}
	public static Pair xRange(ArrayList<Sum> list, int targetX) {
		int hi = list.size()-1;
		int lo = 0;
		while (hi>lo) {
			int mid = (hi+lo)/2;
			if (list.get(mid).xSum<targetX) {
				lo = mid+1;
			}
			else {
				hi = mid;
			}
		}
		int lowerBound = hi;
		hi = list.size()-1;
		lo = 0;
		while (hi>lo) {
			int mid = (hi+lo+1)/2;
			if (list.get(mid).xSum>targetX) {
				hi = mid-1;
			}
			else {
				lo = mid;
			}
		}
		int upperBound = hi;
		return new Pair(lowerBound, upperBound);
	}
	public static int findY(ArrayList<Sum> list, int targetY, int lower, int upper) {
		int hi = upper;
		int lo = lower;
		while (hi>lo) {
			int mid = (hi+lo)/2;
			if (list.get(mid).ySum<targetY) {
				lo = mid+1;
			}
			else {
				hi = mid;
			}
		}
		return hi;
	}
	static class Sum {
		int xSum, ySum;
		int numIncluded;
		public Sum(int xSum, int ySum, int numIncluded) {
			this.xSum = xSum;
			this.ySum = ySum;
			this.numIncluded = numIncluded;
		}
	}
	static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(
	           new InputStreamReader(System.in));
	        pr = new PrintWriter(System.out);
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
