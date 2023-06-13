import java.io.*;
import java.util.*;
public class BeautifulNumber {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		ArrayList<Integer> nums1 = new ArrayList<Integer>();
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		for (int i=1; i<=9; i++) {
			dfs1(i+"", i, nums1, 1);
		}
		nums2.addAll(nums1);
		for (int i=1; i<=9; i++) {
			for (int j=0; j<=9; j++) {
				if (i==j) continue;
				dfs2(i+"", i, j, nums2, 1);
			}
		}
		nums1.add(1111111111);
		nums2.add(1000000000);
		Collections.sort(nums1);
		Collections.sort(nums2);
		
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int k = in.nextInt();
			if (k==1) {
				int index = Collections.binarySearch(nums1, n);
				if (index<0) {
					index+=1;
					index*=-1;
				}
				System.out.println(nums1.get(index));
			}
			else {
				int index = Collections.binarySearch(nums2, n);
				if (index<0) {
					index+=1;
					index*=-1;
				}
				System.out.println(nums2.get(index));
			}
		}
	}
	public static void dfs1(String num, int digit, ArrayList<Integer> nums, int numDigits) {
		if (numDigits>9) return;
		nums.add(Integer.parseInt(num));
		dfs1(num+digit, digit, nums, numDigits+1);
	}
	public static void dfs2(String num, int digit1, int digit2, ArrayList<Integer> nums, int numDigits) {
		if (numDigits>9) return;
		nums.add(Integer.parseInt(num));
		dfs2(num+digit1, digit1, digit2, nums, numDigits+1);
		dfs2(num+digit2, digit1, digit2, nums, numDigits+1);
		
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
