import java.io.*;
import java.util.*;
public class Pattycakes {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int t = in.nextInt();
		for (int tc=0; tc<t; tc++) {
			int n = in.nextInt();
			int[] nums = new int[n];
			for (int i=0; i<n; i++) {
				nums[i] = in.nextInt();
			}
			Arrays.parallelSort(nums);
			int hi = nums.length-2;
			int lo = 0;
			while (hi>lo) {
				int mid = (hi+lo+1)/2;
				if (check(mid, nums, n)) lo = mid;
				else hi = mid-1;
			}
			System.out.println(hi);
		}
	}
	public static boolean check(int x, int[] nums, int n) {
		PriorityQueue<Number> pq = new PriorityQueue<Number>((o1, o2) -> Integer.compare(o2.occurences, o1.occurences));
		int prev = nums[0];
		int streak = 1;
		for (int i=1; i<n; i++) {
			if (nums[i]!=prev) {
//				System.out.println(streak+" "+prev);
				pq.add(new Number(prev, streak));
				streak = 0;
			}
			streak++;
			prev = nums[i];
		}
		pq.add(new Number(prev, streak));
		Queue<Number> unusable = new LinkedList<Number>();
		int placed = 0;
		while (!pq.isEmpty()) {
			Number curr = pq.poll();
			curr.occurences--;
			unusable.add(curr);
			placed++;
			if (unusable.size()==x+1) {
				Number next = unusable.poll();
				if (next.occurences>0) pq.add(next);
			}
		}
		return placed==n;
		
	}
	static class Number {
		int value, occurences;
		public Number(int value, int occurences) {
			this.value = value;
			this.occurences = occurences;
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
