import java.io.*;
import java.util.*;
public class CowPairs {
	static int n;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("pairup.in", "pairup.out");
		n = in.nextInt();
		ArrayList<CowGroup> cowGroups = new ArrayList<CowGroup>();
		for (int i=0; i<n; i++) {
			int num = in.nextInt();
			int output = in.nextInt();
			cowGroups.add(new CowGroup(num, output));
		}
		Collections.sort(cowGroups);
		int left = 0;
		int right = n-1;
		int maxTime = 0;
		while (right>=left) {
			maxTime = Math.max(cowGroups.get(left).output + cowGroups.get(right).output, maxTime);
			if (cowGroups.get(left).num>cowGroups.get(right).num) {
				cowGroups.get(left).num -= cowGroups.get(right).num;
				right--;
			}
			else if (cowGroups.get(left).num<cowGroups.get(right).num) {
				cowGroups.get(right).num -= cowGroups.get(left).num;
				left++;
			}
			else {
				right--;
				left++;
			}
		}
		in.pr.println(maxTime);
		in.pr.close();
	}
	static class CowGroup implements Comparable<CowGroup> {
		int num, output;
		public CowGroup(int num, int output) {
			this.num = num;
			this.output = output;
		}
		@Override
		public int compareTo(CowGroup o) {
			// TODO Auto-generated method stub
			return Integer.compare(output, o.output);
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