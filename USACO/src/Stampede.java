import java.io.*;
import java.util.*;
public class Stampede {
	static int n;
	public static void main(String[] args) throws IOException {
		FastIO in = new FastIO("USACOinput1", "stampede.out");
		n=in.nextInt();
		ArrayList<Event> events = new ArrayList<Event>();
		for (int i=0; i<n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int r = in.nextInt();
			int arrival=-1*(x+1)*r;
			int departure = -1*(x)*r;
			Event arrive = new Event(arrival, i, true, y);
			Event depart = new Event(departure, i, false, y);
			events.add(arrive);
			events.add(depart);
		}
		Collections.sort(events);
		TreeSet<Cow> currentEvents = new TreeSet<Cow>();
		Set<Integer> cowsSeen = new HashSet<Integer>();
		for (Event event: events) {
			Cow cow = new Cow(event.ycoor, event.cowID);
			
			if (currentEvents.contains(cow)) {
				currentEvents.remove(cow);
			}
			else {
				currentEvents.add(cow);
			}
			if (currentEvents.size()>=1) {
				cowsSeen.add(currentEvents.first().cowID);
			}
			
		}
		System.out.println(cowsSeen.size());
	}
	
	static class Cow implements Comparable<Cow> {
		int ycoor, cowID;
		public Cow(int ycoor, int cowID) {
			this.ycoor = ycoor;
			this.cowID=cowID;
		}
		@Override
		public int compareTo(Cow o) {
			// TODO Auto-generated method stub
			return Integer.compare(ycoor, o.ycoor);
		}
		@Override
	    public boolean equals(Object o) {
			Cow c = (Cow)o;
			return cowID==c.cowID;
		}
		
	}
	
	static class Event implements Comparable<Event>{
		int time, cowID, ycoor;
		boolean isArrival;
		public Event(int time, int cowID, boolean isArrival, int ycoor) {
			this.time=time;
			this.cowID=cowID;
			this.isArrival=isArrival;
			this.ycoor=ycoor;
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
