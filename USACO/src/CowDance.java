import java.io.*;
import java.util.*;
public class CowDance {
	static int n, t;
	static int[] danceTimes;
	
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("cowdance.in", "cowdance.out");
		n = in.nextInt();
		t = in.nextInt();
		danceTimes = new int[n];
		for (int i=0; i<n; i++) {
			danceTimes[i] = in.nextInt();
			
		}
		int high = n;
		int low = 0;
		while (high>low) {
			int mid = (high+low)/2;
			if (doesFit(mid)) {
				high = mid;
			}
			else low = mid+1;
		}
		in.pr.println(high);
		in.pr.close();
	}
	
	public static boolean doesFit(int size) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i=0; i<size; i++) {
			pq.add(danceTimes[i]);
		}
		int time = 0;
		int previous = 0;
		int index = size;
		while (!pq.isEmpty()) {
			int curr = pq.poll();
//			System.out.println(curr);
			time+=(curr-previous);
			previous=curr;
			if (index<n) {
				pq.add(danceTimes[index]+previous);
				index++;
			}
		}
		if (time>t) return false;
		return true;
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
