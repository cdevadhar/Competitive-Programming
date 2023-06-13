import java.io.*;
import java.util.*;
public class RPS {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		int[] a = new int[3];
		int[] b = new int[3];
		for (int i=0; i<3; i++) {
			a[i] = in.nextInt();
		}
		for (int i=0; i<3; i++) {
			b[i] = in.nextInt();
		}
		int max = Math.min(a[0], b[1])+Math.min(a[1], b[2])+Math.min(a[2], b[0]);
		
		ArrayList<List<Integer>> permutations = new ArrayList<List<Integer>>(720);
		List<Integer> indexes = Arrays.asList(0, 1, 2, 3, 4, 5);
		permute(indexes, permutations, 0);
		int[][] nonWins = new int[6][2];
		nonWins[1][0] = 1;
		nonWins[1][1] = 1;
		nonWins[2][0] = 2;
		nonWins[2][1] = 2;
		nonWins[3][0] = 0;
		nonWins[3][1] = 2;
		nonWins[4][0] = 1;
		nonWins[4][1] = 0;
		nonWins[5][0] = 2;
		nonWins[5][1] = 1;
//		int maxNonWins = 0;
		int totalMin = Integer.MAX_VALUE;
		for (List<Integer> perm: permutations) {
//			System.out.println("a");
			int[] aTemp = a.clone();
			int[] bTemp = b.clone();
//			int notWins = 0;
			for (int index: perm) {
				int move = Math.min(aTemp[nonWins[index][0]], bTemp[nonWins[index][1]]);
//				System.out.println(index+" "+move);
//				notWins+=move;
				if (aTemp[nonWins[index][0]]==move) {
					aTemp[nonWins[index][0]] = 0;
					bTemp[nonWins[index][1]]-=move;
				}
				else {
					bTemp[nonWins[index][1]] = 0;
					aTemp[nonWins[index][0]]-=move;
				}
				
			}
			int minWins = Math.min(aTemp[0], bTemp[1])+Math.min(aTemp[1], bTemp[2])+Math.min(aTemp[2], bTemp[0]);
			totalMin = Math.min(totalMin, minWins);
//			System.out.println(minWins);
//			maxNonWins = Math.max(notWins, maxNonWins);
		}
//		System.out.println(n-maxNonWins);
		System.out.println(totalMin+" "+max);
	}
	public static void permute(List<Integer> nums, ArrayList<List<Integer>> permutations, int k) {
		for (int i=k; i<nums.size(); i++) {
			Collections.swap(nums, i, k);
			permute(nums, permutations, k+1);
			Collections.swap(nums, k, i);
		}
		if (k==nums.size()-1) {
			ArrayList<Integer> perm = new ArrayList<Integer>(6);
			for (int i:nums) perm.add(i);
			permutations.add(perm);
//			System.out.println(perm);
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
