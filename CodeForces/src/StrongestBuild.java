import java.io.*;
import java.util.*;
public class StrongestBuild {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		ArrayList<ArrayList<Integer>> slots = new ArrayList<ArrayList<Integer>>();
		HashSet<ArrayList<Integer>> banned = new HashSet<ArrayList<Integer>>();
		ArrayList<Integer> start = new ArrayList<Integer>();
		int startPower=0;
		for (int i=0; i<n; i++) {
			int size = in.nextInt();
			slots.add(new ArrayList<Integer>(size));
			for (int j=0; j<size; j++) {
				int x = in.nextInt();
				slots.get(i).add(x);
				if (j==size-1) {
					start.add(j);
					startPower+=x;
				}
			}
		}
		int m = in.nextInt();
				for (int i=0; i<m; i++) {
			ArrayList<Integer> build = new ArrayList<Integer>(n);
			for (int j=0; j<n; j++) {
				int x = in.nextInt()-1;
				build.add(x);
			}
			banned.add(build);
		}
		Build ans = search(banned, slots, new HashSet<ArrayList<Integer>>(), new Build(startPower, start));
		for (int i=0; i<n; i++) {
			System.out.print(ans.values.get(i)+1+" ");
		}
//		System.out.println(banned.contains(start));
	}
	public static Build search(HashSet<ArrayList<Integer>> banned, ArrayList<ArrayList<Integer>> slots, HashSet<ArrayList<Integer>> visited, Build start) {
		PriorityQueue<Build> pq = new PriorityQueue<Build>((o1, o2) -> Integer.compare(o2.power, o1.power));
		if (!banned.contains(start.values)) return start;
		pq.add(start);
		while (!pq.isEmpty()) {
			Build curr = pq.poll();
			
			if (!banned.contains(curr.values)) return curr;
			visited.add(curr.values);
			
			for (int i=0; i<curr.values.size(); i++) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.addAll(curr.values);
//				System.out.println("Value" + curr.values.get(i)+" ");
//				System.out.println(curr.power);
				if (curr.values.get(i)>0) {
					int diff = slots.get(i).get(curr.values.get(i))-slots.get(i).get(curr.values.get(i)-1);
					
					temp.set(i, temp.get(i)-1);
//					System.out.print(curr.values.get(i)+" "+temp.get(i)+" ");
					Build next = new Build(curr.power-diff, temp);
//					for (int x: temp) {
//						System.out.println("Temp: " + x);
//					}
					if (!visited.contains(temp)) {
						pq.add(next);
					}
				}
			}
//			System.out.println();
		}
		return start;
		
	}
	static class Build {
		int power;
		ArrayList<Integer> values;
		public Build(int power, ArrayList<Integer> values) {
			this.power = power;
			this.values = values;
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
