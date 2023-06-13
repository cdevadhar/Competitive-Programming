import java.io.*;
import java.util.*;


public class Steeplechase2 {
	static int n;
	static Event[] events;
	static Line[] lines;
	static int[] intersections;
	public static void main(String[] args) throws Exception {
		FastIO in = new FastIO("USACOinput1", "cowjump.out");
		n = in.nextInt();
		intersections = new int[n];
		events = new Event[2*n];
		lines = new Line[n];
		for (int i=0; i<n; i++) {
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			if (x1<x2) {
				Event start = new Event(x1, y1, true, i);
				Event end = new Event(x2, y2, false, i);
				lines[i] = new Line(x1, y1, x2, y2);
				start.other = end;
				end.other = start;
				events[2*i] = start;
				events[2*i+1] = end;
			}
			else {
				Event start = new Event(x2, y2, true, i);
				Event end = new Event(x1, y1, false, i);
				lines[i] = new Line(x2, y2, x1, y1);
				start.other = end;
				end.other = start;
				events[2*i] = start;
				events[2*i+1] = end;
			}
		}
		Arrays.parallelSort(events, (o1, o2) -> Integer.compare(o1.x, o2.x));
		TreeSet<Event> activeLines = new TreeSet<Event>((o1, o2) -> Integer.compare(o1.y, o2.y));
		Event a = null, b = null;
		for (int i=0; i<2*n; i++) {
			if (activeLines.contains(events[i])) {
				activeLines.remove(events[i]);
				continue;
			}
			
			activeLines.add(events[i]);
			if (activeLines.higher(events[i])!=null) {
				boolean intersection = doIntersect(lines[events[i].id], lines[activeLines.higher(events[i]).id]);
				if (intersection) {
					System.out.println(events[i].id);
					System.out.println(activeLines.higher(events[i]).id);
					a = events[i];
					b = activeLines.higher(events[i]);
					break;
				}
			}
			if (activeLines.lower(events[i])!=null) {
				boolean intersection = doIntersect(lines[events[i].id], lines[activeLines.lower(events[i]).id]);
				if (intersection) {
					System.out.println(events[i]);
					System.out.println(activeLines.lower(events[i]));
					a = events[i];
					b = activeLines.lower(events[i]);
					break;
				}
			}
		}
		System.out.println(a.id + " " + b.id);
	
	}
	public static boolean doIntersect(Line l1, Line l2) {
		if (l1.x1>l2.x2 || l2.x1>l1.x2) return false;
		
		int start = Math.max(l1.x1, l2.x1);
		int end = Math.min(l1.x2, l2.x2);
		double startDiff = (l1.slope*l1.x1+l1.yInt)-(l2.slope*l2.x1+l2.yInt);
		double endDiff =  (l1.slope*l1.x2+l1.yInt)-(l2.slope*l2.x2+l2.yInt);
		if (startDiff==0 || endDiff==0) return true;
		if (startDiff<0 && endDiff>0) return true;
		if (startDiff>0 && endDiff<0) return true;
		return false;
	}
	
	static class Line {
		int x1, y1, x2, y2;
		double slope, yInt;
		public Line(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
			this.slope = (double)(y2-y1)/(x2-x1);
			this.yInt = y1-slope*x1;
		}
	}
	static class Event {
		int x, y, id;
		
		boolean start;
		Event other;
		public Event(int x, int y, boolean start, int id) {
			this.x = x;
			this.y = y;
			this.start = start;
			this.id = id;
		}
		
		@Override
		public boolean equals(Object other) {
			return ((Event)other).id==id;
		}
		
		@Override
		public int hashCode() {
			return id;
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
