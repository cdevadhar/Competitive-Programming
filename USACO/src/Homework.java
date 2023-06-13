import java.io.*;
import java.util.*;
public class Homework {
	static int n;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO("homework.in", "homework.out");
		n = in.nextInt();
		int[] suffixSum = new int[n+1];
		int[] suffixMin = new int[n+1];
		int[] questions = new int[n];
		for (int i=0; i<n; i++) {
			int x = in.nextInt();
			questions[i] = x;
		}
		int min=Integer.MAX_VALUE;
		for (int i=n-1; i>=0; i--) {
			suffixSum[i] = suffixSum[i+1]+questions[i];
			if (questions[i]<min) {
				min = questions[i];
			}
			suffixMin[i] = min;
		}
		double maxScore=0;
		for (int i=1; i<n-1; i++) {
			double average = ((double)(suffixSum[i]-suffixMin[i]))/(n-i-1);
			if (average>maxScore) maxScore=average;
		}
		for (int i=1; i<n-1; i++) {
			double average = ((double)(suffixSum[i]-suffixMin[i]))/(n-i-1);
			if (average==maxScore) in.pr.println(i);
		}
		in.pr.close();
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
