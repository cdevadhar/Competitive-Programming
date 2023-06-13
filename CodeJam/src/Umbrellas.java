import java.io.*;
import java.util.*;
public class Umbrellas {
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i=0; i<t; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			String s = in.next();
			System.out.println("Case #" + (i+1) + ": " + minCost(s, x, y));
		}
		
	}
	
	public static int minCost(String s, int x, int y) {
		int cost=0;
		char[] art = new char[s.length()];
		for (int i=0; i<s.length(); i++) {
			
			if (s.charAt(i) == 'J') art[i] = 'J';
			else if (s.charAt(i) == 'C') art[i] = 'C';
			else {
				if (i>0) {
					if (s.charAt(i-1)=='?') {
						continue;
					}
					else art[i]='.';
				}
				else art[i] = '.';
			}
			
		}
		for (int i=0; i<art.length-1; i++) {
			
			if (art[i]=='C' && art[i+1]=='J') cost +=x;
			if (art[i]=='J' && art[i+1]=='C') cost +=y;
			if (i>0) {
				if (art[i]=='.') {
					if (closestBehind(i, art)!=10000 && closestAhead(i, art)!=10000) {
						if (art[closestBehind(i, art)]=='C' && art[closestAhead(i, art)]=='J') cost +=x;
						if (art[closestBehind(i, art)]=='J' && art[closestAhead(i, art)]=='C') cost +=y;
					}
					
				}
			}
		}
		return cost;
		
	}
	public static int closestBehind(int index, char[] art) {
		int behind=10000;
		for (int i=index-1; i>=0; i--) {
			if (art[i]=='C' || art[i]=='J') {
				behind = i;
				break;
			}
		}
		return behind;
	}
	public static int closestAhead(int index, char[] art) {
		int ahead = 10000;
		for (int i=index+1; i<art.length; i++) {
			if (art[i]=='C' || art[i]=='J') {
				ahead = i;
				break;
			}
		}
		return ahead;
	}
}
