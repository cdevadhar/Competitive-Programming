import java.io.*;
import java.util.*;
public class Acowdemia {
	static int n, k, l;
	static int[] citations;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    k = Integer.parseInt(st.nextToken());
	    l = Integer.parseInt(st.nextToken());
	    st = new StringTokenizer(br.readLine());
	    citations = new int[n];
	    for (int i=0; i<n; i++) {
	    	int c = Integer.parseInt(st.nextToken());
	    	citations[i] = c;
	    }
//	    System.out.println(canReach(4));
	    search();
	}
	
	public static void search() {
		int high = 100000;
		int low = 0;
		while (high>low) {
			int mid = (high+low+1)/2;
			if (canReach(mid)) {
				low = mid;
			}
			else {
				high = mid-1;
			}
		}
		System.out.println(low);
	}
	
	public static boolean canReach(int index) {
		int citationsLeft = k*l;
		int[] temp = citations.clone();
		int[] surveys = new int[k];
		for (int i=0; i<k; i++) {
			surveys[i] = l;
		}
		int count = 0;
		for(int i=0; i<n; i++) {
			int c = temp[i];
			if (c<index) {
				int m = index-c;
				if (m<=k && m<=citationsLeft) {
					citationsLeft -=m;
					count++;
				}
			}
			else {
				count ++;
			}
		}
		if (count>=index) return true;
		return false;
	}
}
