import java.io.*;
import java.util.*;
public class Partnering {
	static Scanner in;
//	static ArrayList<Activity> schedule;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i=0; i<n; i++) {
			int m = in.nextInt();
			ArrayList<Activity> activities = new ArrayList<Activity>();
			for (int j=0; j<m; j++) {
				int start = in.nextInt();
				int end = in.nextInt();
				Activity act = new Activity(start, end);
				activities.add(act);
			}
//			for (int j=0; j<activities.size(); j++) {
//				System.out.println(activities.get(j).start + " " + activities.get(j).end);
//			}
//			System.out.println();
			System.out.println("Case #" + (i+1) + ": "+greedy(activities));
//			for (int j=0; j<acts.size(); j++) {
//				System.out.println(acts.get(j).start);
//			}
		}
		
	}
	
	public static String greedy(ArrayList<Activity> activities) {
		ArrayList<Activity> acts = new ArrayList<Activity>(activities);
		Collections.sort(acts);
		int currenttime = 0;
		ArrayList<Activity> Cameron = new ArrayList<Activity>();
		ArrayList<Activity> Jamie = new ArrayList<Activity>();
		for (int i=0; i<acts.size(); i++) {
			if (acts.get(i).start>=currenttime) {
				currenttime = acts.get(i).end;
				Cameron.add(acts.get(i));
			}
		}
		currenttime = 0;
		for (int i=0; i<acts.size(); i++) {
			if (acts.get(i).start>=currenttime && !Cameron.contains(acts.get(i))) {
				currenttime = acts.get(i).end;
				Jamie.add(acts.get(i));
			}
		}
		
//		for (int i=0; i<Jamie.size(); i++) {
//			System.out.println(Jamie.get(i).start + " " + Jamie.get(i).end);
//		}
		String ans = "";
		for (int i=0; i<activities.size(); i++) {
//			System.out.println(activities.get(i).start + " " + activities.get(i).end);
			if (Cameron.contains(activities.get(i))) ans = ans.concat("C");
			if (Jamie.contains(activities.get(i))) ans = ans.concat("J");
		}
		if (Cameron.size() + Jamie.size() < activities.size()) {
			return "IMPOSSIBLE";
		}
		return ans;
		
	}
}

class Activity implements Comparable<Activity> {
	int start, end;
	public Activity(int start, int end) {
		this.end = end;
		this.start = start;
	}
	@Override
	public int compareTo(Activity o) {
		// TODO Auto-generated method stub
		return Integer.compare(start, o.start);
	}
}
