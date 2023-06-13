import java.io.*;
import java.util.*;
public class Physicist {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int xForce = 0, yForce = 0, zForce = 0;
	    
	    for (int i=0; i<n; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int x = Integer.parseInt(st.nextToken());
	    	int y = Integer.parseInt(st.nextToken());
	    	int z = Integer.parseInt(st.nextToken());
	    	xForce+=x;
	    	yForce+=y;
	    	zForce+=z;
	    }
	    if (xForce==0 && yForce==0 && zForce ==0) {
	    	System.out.println("YES");
	    }
	    else System.out.println("NO");
	}
}
