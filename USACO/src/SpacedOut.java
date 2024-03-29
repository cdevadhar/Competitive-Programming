import java.io.*;
import java.util.*;
public class SpacedOut {
	static int n;
	static int[][] beauty;
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		n = in.nextInt();
		beauty = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				beauty[i][j] = in.nextInt();
			}
		}
		int a = alternateColumns();
		int b = alternateRows();
		System.out.println(Integer.max(a, b));
	}
	
	public static int alternateRows() {
		int totalBeauty = 0;
		for (int i=0; i<n; i++) {
			int n = columnBeauty(i);
			totalBeauty += n;
		}
		return (totalBeauty);
	}
	public static int alternateColumns() {
		int totalBeauty = 0;
		for (int i=0; i<n; i++) {
			int n = rowBeauty(i);
			totalBeauty += n;
		}
		return (totalBeauty);
	}
	
	public static int columnBeauty(int column) {
		int emptyFirst = 0;
		int cowFirst = 0;
		for (int i=0; i<n; i++) {
			if (i%2==0) cowFirst+=beauty[i][column];
			else emptyFirst+=beauty[i][column];
		}
		return Integer.max(cowFirst, emptyFirst);
	}
	public static int rowBeauty(int row) {
		int emptyFirst = 0;
		int cowFirst = 0;
		for (int i=0; i<n; i++) {
			if (i%2==0) cowFirst+=beauty[row][i];
			else emptyFirst+=beauty[row][i];
		}
		return Integer.max(cowFirst, emptyFirst);
	}
}
