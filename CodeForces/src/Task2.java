import java.io.*;
import java.util.*;
public class Task2 {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			char[] s = in.next().toCharArray();
			int m = in.nextInt();
			int[] b = new int[m];
			for (int i=0; i<m; i++) {
				b[i] = in.nextInt();
			}
			Arrays.parallelSort(s);
//			for (char c: s) System.out.print(c);
//			System.out.println();
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			while (true) {
				ArrayList<Integer> curr = new ArrayList<Integer>();
				for (int i=0; i<m; i++) {
					if (b[i]==0) curr.add(i);
				}
				if (curr.isEmpty()) break;
				list.add(curr);
				for (int i=0; i<m; i++) {
					if (b[i]==0) b[i] = Integer.MAX_VALUE;
					else {
						for (int x: curr) {
							b[i]-=Math.abs(i-x);
						}
					}
				}
			}
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (char c: s) {
				map.putIfAbsent(c, 0);
				map.put(c, map.get(c)+1);
			}
			char[] ans = new char[m];
			int index = s.length-1;
//			System.out.println(list.size());
			for (int i=0; i<list.size(); i++) {
//				System.out.println(list.get(i).size());
				char curr = s[index];
				while (map.get(curr)<list.get(i).size()) {
					index--;
					curr = s[index];
				}
				for (int j: list.get(i)) {
					ans[j] = curr;
				}
				while (index>=0 && s[index]==curr) index--;
				
			}
			for (char c: ans) System.out.print(c);
			System.out.println();
		}
	}
	static class FastIO {
		BufferedReader br;
	    StringTokenizer st;
	    PrintWriter pr;
	    public FastIO() throws IOException
	    {
	        br = new BufferedReader(new InputStreamReader(System.in));
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
