import java.io.*;
import java.util.*;
public class Haybales {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("trapped.in", "trapped.out");
		int n = in.nextInt();
		int b = in.nextInt();
		Haybale[] haybales = new Haybale[n];
		for (int i=0; i<n; i++) {
			int s = in.nextInt();
			int p = in.nextInt();
			haybales[i] = new Haybale(p, s);
		}
		Arrays.parallelSort(haybales, (o1, o2) -> Integer.compare(o1.position, o2.position));
		int left = 0;
		int right = 0;
		for (int i=1; i<n; i++) {
			if (haybales[i-1].position<b && haybales[i].position>b) {
				left = i-1;
				right = i;
			}
		}
		int tempLeft = left, tempRight = right;
		int ans = Integer.MAX_VALUE;
		while (left>=0) {
			while (right<n && haybales[right].size<haybales[right].position-haybales[left].position) right++;
			if (right==n) break;
			int balesNeeded = Math.max(0, (haybales[right].position-haybales[left].position)-haybales[left].size);
			ans = Math.min(ans, balesNeeded);
			left--;
		}
		left = tempLeft;
		right = tempRight;
		while (right<n) {
			while (left>=0 && haybales[left].size<haybales[right].position-haybales[left].position) left--;
			if (left==-1) break;
			int balesNeeded = Math.max(0, (haybales[right].position-haybales[left].position)-haybales[right].size);
			ans = Math.min(ans, balesNeeded);
			right++;
		}
		if (ans==Integer.MAX_VALUE) ans = -1;
		in.pr.println(ans);
		in.pr.close();
	}
	static class Haybale {
		int position, size;
		public Haybale(int position, int size) {
			this.position = position;
			this.size = size;
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
