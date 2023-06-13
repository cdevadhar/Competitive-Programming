import java.io.*;
import java.util.*;
public class RoundingError {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int t = Integer.parseInt(st.nextToken());
	    for (int i=0; i<t; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int n = Integer.parseInt(st.nextToken());
	    	int l = Integer.parseInt(st.nextToken());
	    	st = new StringTokenizer(br.readLine());
	    	int[] array = new int[l];
	    	for (int j=0; j<l; j++) {
	    		int a = Integer.parseInt(st.nextToken());
	    		array[j] = a;
	    	}
	    	solve(array, n);
	    }
	    System.out.println(peopleNeeded(200, 1));
	}
	
	public static int peopleNeeded(int n, int x) {
		for (int i=0; i<n; i++) {
			double current = i+x;
//			System.out.println(current/n*100);
			if ((current/n*100)%1>=0.5) {
				return i;
			}
		}
		return -1;
	}
	
	public static void solve(int[] array, int n) {
		int count = 0;
		int currentPeople = 0;
		ArrayList<Integer> counts = new ArrayList<Integer>();
		for (int i=0; i<array.length; i++) {
			int x = peopleNeeded(n, array[i]);
			System.out.println(x);
			currentPeople+=array[i];
			if (x==0) count++;
			else if (x!=-1) counts.add(x);
		}
		Collections.sort(counts);
		int index=0;
		
		
		for (int i=0; i<counts.size(); i++) {
			int m = currentPeople+counts.get(i);
			if (m>n) break;
			System.out.println("hello");
			int y = peopleNeeded(n, 0);
			while (y<=counts.get(i) && currentPeople+y<=n && y!=-1 ) {
				currentPeople+=y;
				count++;
			}
			if (currentPeople+counts.get(i)>n) break;
			currentPeople+=counts.get(i);
			count++;
		}
		int y = peopleNeeded(n, 0);
		while (currentPeople+y<=n && y!=-1 ) {
			currentPeople+=y;
			count++;
		}
		
		System.out.println("result:"+count);
		
	}
}
