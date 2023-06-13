import java.io.*;
import java.util.*;
public class Cereal {
	static int n, m;
	static int[][] cereals;
	static int[] sol;
	static HashMap<Integer, Integer> takenCereals;
	public static void main(String[] args) throws Exception {
	    FastIO in = new FastIO("cereal.in", "cereal.out");
	    n = in.nextInt();
	    m = in.nextInt();
	    cereals = new int[n][2];
	    sol = new int[n];
	    takenCereals = new HashMap<Integer, Integer>();
	    for (int i=0; i<n; i++) {
	    	int first = in.nextInt();
	    	int second = in.nextInt();
	    	cereals[i][0] = first;
	    	cereals[i][1] = second;
	    }
	    solve();
	    for (int i=0; i<n; i++) {
	    	in.pr.println(sol[i]);
	    }
	    in.pr.close();
	}
	
	public static void solve() {
		int index = n-1;
		while (index>=0) {
			if (takenCereals.containsKey(cereals[index][0])) {
//				int currCow = takenCereals.get(cereals[index][0]);
				takeCereal(index, cereals[index][0]);
			}
			else {
				takenCereals.put(cereals[index][0], index);
			}
			sol[index] = takenCereals.size();
			index--;
			
		}
	}
	
	public static void takeCereal(int cow, int cereal) {
		if (!takenCereals.containsKey(cereal)) {
			takenCereals.put(cereal, cow);
			return;
		}
		else if (takenCereals.get(cereal)<cow) {
			return;
		}
		else if (takenCereals.get(cereal)>cow) {
			int curr = takenCereals.get(cereal);
			takenCereals.put(cereal, cow);
			if (cereal==cereals[curr][0]) {
				takeCereal(curr, cereals[curr][1]);
			}
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
