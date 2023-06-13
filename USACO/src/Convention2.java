import java.io.*;
import java.util.*;

public class Convention2 {
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("convention2.in", "convention2.out");
		int n = in.nextInt();
		PriorityQueue<Event> events = new PriorityQueue<Event>((o1, o2) -> {
			if (o1.time==o2.time) return Integer.compare(o1.seniority, o2.seniority);
			return Integer.compare(o1.time, o2.time);
		});
		
		for (int i=0; i<n; i++) {
			int time = in.nextInt();
			int timeSpent = in.nextInt();
			events.add(new Event(i, time, timeSpent));
		}
		
		PriorityQueue<Event> pq = new PriorityQueue<Event>((o1, o2) -> {
			return Integer.compare(o1.seniority, o2.seniority);
		});
		int time = events.peek().time;
		int maxTime = 0;
		while (!events.isEmpty() || !pq.isEmpty()) {
			if (!events.isEmpty() && pq.isEmpty()) {
				Event curr = events.poll();
				pq.add(curr);
			}
			
			Event curr2 = pq.poll();
			if (curr2.time>time) {
				time = curr2.time;
			}
//			System.out.println(curr2.time+" "+curr2.timeSpent);
			maxTime = Math.max(time-curr2.time, maxTime);
			events.add(new Event(curr2.seniority, time+curr2.timeSpent, -1));
			Event next = events.peek();
			while (next!=null && next.seniority!=curr2.seniority) {
//				System.out.println("added a cow");
				pq.add(events.poll());
				next = events.peek();
			}
			time = events.poll().time;
//			System.out.println(time);
		}
		in.pr.println(maxTime);
		in.pr.close();
	}
	static class Event {
		int seniority, time, timeSpent;
		public Event(int seniority, int time, int timeSpent) {
			this.seniority = seniority;
			this.time = time;
			this.timeSpent = timeSpent;
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