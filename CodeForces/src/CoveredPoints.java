import java.io.*;
import java.util.*;

public class CoveredPoints {
	static Event[] events;
	static HashSet<Event> activeLines;
	static int[] coverage;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO();
		int n = in.nextInt();
		events = new Event[n*2];
		activeLines = new HashSet<Event>();
		coverage = new int[n];
		for (int i=0; i<n; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			events[i*2] = new Event(start, true, i);
			events[i*2+1] = new Event(end, false, i);
			
		}
		Arrays.parallelSort(events);
		int index = 0;
		int previous = 0;
		while (index<2*n) {
			
			int temp = index;
			if (!activeLines.isEmpty()) {
				System.out.println((events[temp].point-previous-1)+ " more are covered by " + activeLines.size());
				coverage[activeLines.size()-1]+=(events[temp].point-previous-1);
			}
			//Process all starts of a line first
			while (index<2*n && events[index].point==events[temp].point && events[index].isStart) {
				
				activeLines.add(events[index]);
				System.out.println("Added " + events[index].point);
				index++;
			}
			System.out.println(index);
			System.out.println("Another is covered by " + activeLines.size());
			coverage[activeLines.size()-1]++;
			previous = events[temp].point;
			while (index<2*n && events[index].point==events[temp].point) {
				System.out.println("Removed " + events[index].point);
				
				System.out.println(activeLines.remove(events[index]));
				index++;
			}
			System.out.println(index);
			
		}
		for (int i=0; i<n; i++) {
			System.out.println(coverage[i]);
		}
	}
	
	static class Event implements Comparable<Event> {
		int point, lineID;
		boolean isStart;
		public Event(int start, boolean isStart, int lineID) {
			point = start;
			this.isStart = isStart;
			this.lineID = lineID;
		}
		@Override
		public int compareTo(Event o) {
			if (o.point==point) {
				if (isStart && !o.isStart) {
					return -1;
				}
				if (!isStart && o.isStart) {
					return 1;
				}
			}
			return Integer.compare(point, o.point);
		}
		
		@Override
		public boolean equals(Object o) {
			return lineID == ((Event)o).lineID;
		}
		@Override
		public int hashCode() {
			return lineID;
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
