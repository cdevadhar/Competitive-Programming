import java.io.*;
import java.util.*;

public class SkyLine {
	public List<List<Integer>> getSkyline(int[][] buildings) {
        ArrayList<Event> events = new ArrayList<Event>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i=0; i<buildings.length; i++) {
            events.add(new Event(buildings[i][0], buildings[i][2], true, i));
            events.add(new Event(buildings[i][1], buildings[i][2], false, i));
        }
        Collections.sort(events, (o1, o2) -> Integer.compare(o1.x, o2.x));
        PriorityQueue<Event> pq = new PriorityQueue<Event>((o1, o2) -> Integer.compare(o2.height, o1.height));
        int maxHeight = 0;
        for (int i=0; i<events.size(); i++) {
            boolean contained = pq.remove(events.get(i));
            if (!contained) {
            	pq.add(events.get(i));
            }
            if (pq.peek().height>maxHeight) {
            	ArrayList<Integer> ans = new ArrayList<Integer>();
            	ans.add(pq.peek().x);
            	ans.add(pq.peek().height);
            	res.add(ans);
            	maxHeight = pq.peek().height;
            }
        }
        return res;
    }
    
    static class Event {
        int x, height, id;
        boolean start;
        public Event(int x, int height, boolean start, int id) {
            this.x = x;
            this.height = height;
            this.start = start;
            this.id = id;
        }
        
        @Override
        public int hashCode() {
            return id;
        }
        
        @Override
        public boolean equals(Object o) {
            return id==((Event)o).id;
        }
    }
}
