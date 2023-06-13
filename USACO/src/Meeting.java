import java.io.*;
import java.util.*;

public class Meeting {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("USACOinput1", "meetings.out");
		int n = in.nextInt();
		int l = in.nextInt();
		Cow[] cows = new Cow[n];
		ArrayList<Integer> leftArrivals = new ArrayList<Integer>();
		ArrayList<Integer> rightArrivals = new ArrayList<Integer>();
		ArrayList<Integer> leftCows = new ArrayList<Integer>();
		ArrayList<Integer> rightCows = new ArrayList<Integer>();
		int weightSum = 0;
		for (int i=0; i<n; i++) {
			int w = in.nextInt();
			int p = in.nextInt();
			int d = in.nextInt();
			cows[i] = new Cow(p, w, d);
			if (d==-1) {
				leftArrivals.add(p);
				leftCows.add(p);
			}
			else {
				rightArrivals.add(l-p);
				rightCows.add(p);
			}
			weightSum+=w;
		}
		Arrays.parallelSort(cows, (o1, o2) -> Integer.compare(o1.pos, o1.pos));
		Collections.sort(leftArrivals);
		Collections.sort(rightArrivals);
		for (int i=0; i<n; i++) {
			if (i<leftArrivals.size()) {
				cows[i].arrival = leftArrivals.get(i);
			}
			else cows[i].arrival = rightArrivals.get(i-leftArrivals.size());
		}
		Arrays.parallelSort(cows, (o1, o2) -> Integer.compare(o1.arrival, o2.arrival));
		int sum = 0;
		int index = 0;
		int t = 0;
		while (sum<(double)(weightSum)/2) {
			sum+=cows[index].weight;
			t = cows[index].arrival;
			index++;
		}
		index = 0;
		int ans = 0;
		Collections.sort(leftCows);
		Collections.sort(rightCows);
		for (int i=0; i<rightCows.size(); i++) {
			while (index<leftCows.size() && leftCows.get(index)<rightCows.get(i)) index++;
			int rightBound = Collections.binarySearch(leftCows, rightCows.get(i)+2*t);
			
			if (rightBound<0) {
				rightBound+=2;
				rightBound*=-1;
			}
//			System.out.println(index+" "+rightBound);
			ans+=(rightBound-index)+1;
			
		}
		System.out.println(ans);
	}
	static class Cow {
		int pos, weight, direction, arrival;
		public Cow(int pos, int weight, int direction) {
			this.pos = pos;
			this.weight = weight;
			this.direction = direction;
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


