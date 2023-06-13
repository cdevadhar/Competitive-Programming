import java.io.*;
import java.util.*;
public class HalfofSame {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] nums = new int[n];
			HashMap<Integer, Integer> occ = new HashMap<Integer, Integer>();
			boolean exit = false;
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			for (int i=0; i<n; i++) {
				nums[i] = in.nextInt();
				occ.putIfAbsent(nums[i], 0);
				occ.put(nums[i], occ.get(nums[i])+1);
				if (occ.get(nums[i])>=n/2) exit = true;
				min = Math.min(min, nums[i]);
				max = Math.max(max, nums[i]);
			}
			if (exit) System.out.println(-1);
			else {
				int finalAns = 0;
				Arrays.parallelSort(nums);
				for (int i=0; i<n; i++) {
					HashSet<Integer> thisDivisors = new HashSet<Integer>();
					int same = 0;
					HashMap<Integer, Integer> divisorOccurences = new HashMap<Integer, Integer>();
					for (int j=i; j<n; j++) {
						int diff = Math.abs(nums[j]-nums[i]);
						if (diff==0) same++;
//						System.out.println(i + " " + diff);
						for (int k=1; k<=Math.sqrt(diff); k++) {
							if (diff%k==0) {
								divisorOccurences.putIfAbsent(k, 0);
								divisorOccurences.put(k, divisorOccurences.get(k)+1);
								if (k!=diff/k) {
									divisorOccurences.putIfAbsent(diff/k, 0);
									divisorOccurences.put(diff/k, divisorOccurences.get(diff/k)+1);
								}
								
							}
						}
					}
					int ans = 0;
					Set<Integer> keys = divisorOccurences.keySet();
//					System.out.println(i);
					for (Integer key: keys) {
//						System.out.println(i + " " + n +" Key: " + key + " Occurences: " + divisorOccurences.get(key));
						
						if (divisorOccurences.get(key)+same>=n/2) {
//							System.out.println(key);
							ans = Math.max(ans, key);
						}
					}
					finalAns = Math.max(ans, finalAns);
				}
				System.out.println(finalAns);
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
