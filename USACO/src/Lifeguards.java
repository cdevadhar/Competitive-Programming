import java.io.*;
import java.util.*;
public class Lifeguards {
	static int n;
	public static void main(String[] args) throws Exception{
		FastIO in = new FastIO("USACOinput1", "lifeguards.out");
		n = in.nextInt();
		Event[] events = new Event[2*n];
		int[] aloneTime = new int[n];
		for (int i=0; i<n; i++) {
			int a = in.nextInt();
			Event start = new Event(a, i, true);
			events[2*i] = start;
			int b = in.nextInt();
			Event end = new Event(b, i, false);
			events[2*i+1] = end;
		}
		Arrays.parallelSort(events);
		int index = 0;
		TreeSet<Integer> lifeGuards = new TreeSet<Integer>();
		int lastTime=0;
		int totalTime = 0;
		for (Event event: events) {
			if (lifeGuards.size()==1) {
				aloneTime[lifeGuards.first()]+=(event.time-lastTime);
			}
			if (!lifeGuards.isEmpty()) {
				totalTime+=event.time-lastTime;
			}
			if (lifeGuards.contains(event.cowNum)) {
				lifeGuards.remove(event.cowNum);
			}
			else {
				lifeGuards.add(event.cowNum);
			}
			lastTime = event.time;
		}
		int maxTime=0;
		for (int i=0; i<n; i++) {
			if ((totalTime-aloneTime[i])>maxTime) maxTime=totalTime-aloneTime[i];
		}
		System.out.println(maxTime);
	}
	
	static class Event implements Comparable<Event>{
		int time, cowNum;
		boolean isStart;
		public Event(int time, int cowNum, boolean isStart) {
			this.time = time;
			this.cowNum = cowNum;
			this.isStart = isStart;
		}
		@Override
		public int compareTo(Event o) {
			// TODO Auto-generated method stub
			return Integer.compare(time, o.time);
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
