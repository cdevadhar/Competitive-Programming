import java.io.*;
import java.util.*;
public class TPrime {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    st = new StringTokenizer(br.readLine());
	    for (int i=0; i<n; i++) {
	    	double num = Double.parseDouble(st.nextToken());
	    	double sqrt = Math.sqrt(num);
	    	if (sqrt%1>0) {
	    		System.out.println("NO");
	    	}
	    	else {
	    		if (isPrime(sqrt)) System.out.println("YES");
	    		else System.out.println("NO");
	    	}
	    	
	    }
	}
	
	public static boolean isPrime(double num) {
		if (num<2) return false;
		if (num==2 || num==3) return true;
		if (num%2==0 || num%3==0) return false;
		for (int i=5; i<=Math.sqrt(num); i+=6) {
			if (num%i==0 || num%(i+2)==0) return false;
		}
		return true;
	}
	
	public static String isTPrime(double num) {
		if (num<4) return "NO";
		if (num==4) return "YES";
		if (num%2==0) return "NO";
		for (int i=3; i<Math.sqrt(num); i++) {
			if (num%i==0) return "NO";
		}
		if (Math.sqrt(num)%1==0) return "YES";
		return "NO";
	}
}
