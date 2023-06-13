import java.io.*;
import java.util.*;
public class CruiseControl {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int t = Integer.parseInt(st.nextToken());
	    for (int i=0; i<t; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int d = Integer.parseInt(st.nextToken());
	    	int n = Integer.parseInt(st.nextToken());
	    	double slowHorse = 0;
	    	for (int j=0; j<n; j++) {
	    		st = new StringTokenizer(br.readLine());
	    		int k = Integer.parseInt(st.nextToken());
	    		int s = Integer.parseInt(st.nextToken());
	    		double time = arrivalTime(k, s, d);
	    		if (time>slowHorse) slowHorse = time;
	    	}
	    	System.out.println("Case #" + (i+1) + ": " + d/slowHorse);
	    }
	}
	
	public static double arrivalTime(int k, int s, int d) {
		double distance = d-k;
		double time = distance/s;
		return time;
	}
}
