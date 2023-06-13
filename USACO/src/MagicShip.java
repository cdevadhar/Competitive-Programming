import java.io.*;
import java.util.*;
public class MagicShip {
	static OrderedPair2 p1;
	static OrderedPair2 p2;
	static int n;
	static char[] wind;
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		p1 = new OrderedPair2(x, y);
		int x2 = in.nextInt();
		int y2 = in.nextInt();
		p2 = new OrderedPair2(x2, y2);
		n = in.nextInt();
		System.out.println(n);
		String w = in.next();
		wind = new char[n];
		for (int i=0; i<n; i++) {
			wind[i] = w.charAt(i);
		}
		
		for (int i=0; i<100; i++) {
			System.out.println(canReach(i));
			p1.x = x;
			p1.y = y;
		}
//		System.out.println(canReach(4));
		System.out.println(search());
		
		
	}
	
	public static int search() {
		int high = 1000000000;
		int low = 0;
		while (high>low) {
			if (canReach((high+low)/2)) {
				high = (high+low)/2;
			}
			else {
				low = (high+low)/2 + 1;
			}
		}
		return high;
	}
	
	public static boolean canReach(int days) {
		for(int i=0; i<days; i++) {
			int j = i%n;
//			System.out.println(j);
			if (wind[j]=='U') p1.y ++;
			if (wind[j]=='D') p1.y --;
			if (wind[j]=='R') p1.x++;
			if (wind[j]=='L') p1.x--;
		}
//		System.out.println(p1.x + " " + p1.y);
		int distanceX = Math.abs(p2.x-p1.x);
//		System.out.println(distanceX);
		int distanceY = Math.abs(p2.y-p1.y);
//		System.out.println(distanceY);
		int dist = distanceX+distanceY;
//		System.out.println(dist);
		
		if (dist<=days) return true;
		return false;
	}
	
}

class OrderedPair2 {
	int x, y;
	public OrderedPair2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
