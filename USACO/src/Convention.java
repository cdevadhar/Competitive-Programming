import java.io.*;
import java.util.*;
public class Convention {
	static int n;
	static int m;
	static int c;
	static int[] arrivalTime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("convention.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		StringTokenizer line = new StringTokenizer(br.readLine());
		arrivalTime=new int[n];
		for (int i=0; i<n; i++) {
			arrivalTime[i] = Integer.parseInt(line.nextToken());
			
		}
		br.close();
		Arrays.sort(arrivalTime);
		pw.println(search(0, 1000000000));
		pw.close();
	}
	
	public static int search(int lo, int hi) {
		int result=0;
		while(lo<=hi) {
			int mid = (lo+hi)/2;
			if (check(mid)) {
				hi=mid-1;
				result=mid;
			}
			else {
				lo = mid+1;
				
			}
		}
		return result;
	}
	
	public static boolean check(int minWait){
        int first = arrivalTime[0]; 
        int used = 1; 
        int curCap = 0;
        for (int i = 0; i < n; i++) {
            if(arrivalTime[i]-first>minWait || curCap >= c){
                used++;
                curCap=0;
                first = arrivalTime[i];
            }
            curCap++;
        }
        return used <= m;
    }
	
}
