import java.io.*;
import java.util.*;
public class Comfortable {
	static int n;
	static boolean[][] pasture;
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		n = in.nextInt();
		pasture = new boolean[1000][1000];
		for (int i=0; i<n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			pasture[a][b] = true;
			ArrayList<CowLoc> cows = countComfortable();
			if (i==n-1) {
				pasture[3][3] = true;
				System.out.println(countComfortable().size());
			}
			else System.out.println(cows.size());
//			for (int j=0; j<cows.size(); j++) {
//				makeUncomfortable(cows.get(i).x, cows.get(j).y);
//			}
		}
		
		
//		cycle();
	}
	
	public static void makeUncomfortable(int row, int col) {
		(pasture[row+1][col])=true;
		(pasture[row-1][col])=true;
		(pasture[row][col+1])=true;
		(pasture[row][col-1])=true;
	}
	
	public static boolean isComfortable(int row, int col) {
		int neighbors = 0;
		if (row<999) {
			if (pasture[row+1][col]) neighbors++;
		}
		if (row>0) {
			if (pasture[row-1][col]) neighbors++;
		}
		
		
		if (col<999) {
			if (pasture[row][col+1]) neighbors++;
		}
		
		if (col>0) {
			if (pasture[row][col-1]) neighbors++;
		}
		
		if (neighbors==3) return true;
		return false;
	}
	
	public static ArrayList<CowLoc> countComfortable() {
		int result=0;
		ArrayList<CowLoc> cows = new ArrayList<CowLoc>();
		for (int i=0; i<1000; i++) {
			for (int j=0; j<1000; j++) {
				if (pasture[i][j] && isComfortable(i, j)) {
					result++;
					CowLoc cow = new CowLoc(i, j);
					cows.add(cow);
//					makeUncomfortable(i, j);
				}
			}
		}
		return cows;
	}
	
//	public static void cycle() {
//		int result = 0;
//		int a = countComfortable();
//		result+=a;
//		while (a>0) {
//			int i = countComfortable();
//			a=i;
//			result+=i;
//		}
//		System.out.println(result);
//	}
}

class CowLoc {
	int x, y;
	boolean comf;
	public CowLoc(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
