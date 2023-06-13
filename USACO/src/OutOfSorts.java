import java.io.*;
import java.util.*;
public class OutOfSorts {
	static int n;
	static Element[] nums, sorted;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO("USACOinput1", "sort.out");
		n = in.nextInt();
		nums = new Element[n];
		sorted = new Element[n];
		for (int i=0; i<n; i++) {
			int x = in.nextInt();
			Element element = new Element(i, x);
			nums[i] = element;
			sorted[i] = element;
		}
		Arrays.parallelSort(sorted);
		int max = 0;
		for (int i=0; i<n; i++) {
			if((sorted[i].originalIndex-i)>max)max=sorted[i].originalIndex-i;
		}
		System.out.println(max+1);
	}
	
	static class Element implements Comparable<Element>{
		int originalIndex, value;
		public Element(int index, int value) {
			this.originalIndex = index;
			this.value = value;
		}
		@Override
		public int compareTo(Element o) {
			// TODO Auto-generated method stub
			return Integer.compare(value, o.value);
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
