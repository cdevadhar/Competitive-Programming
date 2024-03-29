import java.util.*;
import java.io.*;
public class Subtransmutation {
	static int t;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    t = Integer.parseInt(st.nextToken());
	    for (int i=0; i<t; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int n = Integer.parseInt(st.nextToken());
	    	int a = Integer.parseInt(st.nextToken());
	    	int b = Integer.parseInt(st.nextToken());
	    	st = new StringTokenizer(br.readLine());
	    	ArrayList<Integer> metalNeeded = new ArrayList<Integer>();
	    	for (int j=0; j<n; j++) {
	    		int u = Integer.parseInt(st.nextToken());
	    		metalNeeded.add(u);
	    	}
	    }
	}
	
	public static void canProduce(int a, int b, ArrayList<Integer> needed, int start) {
		int current = start;
		if (start-a>0) {
			canProduce(a, b, needed, start-a);
		}
		if (start-b>0) {
			canProduce(a, b, needed, start-b);
		}
		
	}
}
