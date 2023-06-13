import java.io.*;
import java.util.*;
public class MilkMeasurement2 {
	static int n, g;
	static Measurement[] measurements;
	static TreeMap<Integer, Integer> leaderboard;
	static HashMap<Integer, Integer> values;
	static int leaderVal;
	static int numLeaders;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("USACOinput1", "measurement.out");
		n = in.nextInt();
		g = in.nextInt();
		measurements = new Measurement[n];
		leaderVal = g;
		numLeaders = n;
		leaderboard = new TreeMap<Integer, Integer>();
		values = new HashMap<Integer, Integer>();
		for (int i=0; i<n; i++) {
			int day = in.nextInt();
			int cow = in.nextInt();
			int change = in.nextInt();
			measurements[i] = new Measurement(day, cow, change);
			values.put(cow, g);
		}
		Arrays.parallelSort(measurements);
		leaderboard.put(g,  n+1);
		System.out.println(solve());
		in.pr.close();
	}
	
	public static int solve() {
		int days = 0;
		for (int i=0; i<n; i++) {
			Measurement curr = measurements[i];
			int leaderVal = leaderboard.lastKey();
//			System.out.println(leaderVal);
			if (values.get(curr.cowID)==leaderVal) {
//				System.out.println("The current day is " + curr.day + " and this cow is already on the leaderboard");
				
				leaderboard.remove(leaderVal, curr.cowID);
				if (leaderboard.lastKey()==leaderVal+curr.change && curr.change<0) {
					days++;
					continue;
				}
				leaderboard.put(leaderVal+curr.change, curr.cowID);
				if (leaderboard.containsKey(leaderVal)) {
//					System.out.println("changed leaderboard");
					days++;
				}
				else if (leaderboard.lastKey()>leaderVal+curr.change && curr.change<0) {
//					System.out.println("changed leaderboard 2");
					days++;
				}
				
				
			}
			else {
				leaderboard.remove(values.get(curr.cowID), curr.cowID);
				leaderboard.put(values.get(curr.cowID)+curr.change, curr.cowID);
				if (values.get(curr.cowID)+curr.change >= leaderVal) {
					days++;
//					System.out.println("Changed leaderboard 3");
				}
			}
			values.put(curr.cowID, values.get(curr.cowID)+curr.change);
		}
		return days;
		
	}
	static class Measurement implements Comparable<Measurement> {
		int day, cowID, change;
		
		public Measurement(int day, int cowID, int change) {
			this.day = day;
			this.cowID = cowID;
			this.change = change;

		}
		@Override
		public int compareTo(Measurement o) {
			// TODO Auto-generated method stub
			return Integer.compare(day, o.day);
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