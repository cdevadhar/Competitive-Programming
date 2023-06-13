import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation {
	boolean[][] grid;
	int openSites;
	WeightedQuickUnionUF unionFind;
	int n;
	private static final int top = 0;
	private static int bottom;
	public Percolation(int n) {
		this.n = n;
		grid = new boolean[n][n];
		openSites = 0;
		unionFind = new WeightedQuickUnionUF(n*n+2);
		bottom = n*n;
	}
	
	public void open(int row, int col) {
		row--;
		col--;
		check(row, col);
		if (!grid[row][col]) {
			grid[row][col] = true;
			openSites++;
		}
		int index = getIndex(row, col);
		if (row==0) {
			unionFind.union(index, top);
		}
		if (row==n-1) {
			unionFind.union(index, bottom);
		}
		if (row>0 && isOpen(row-1, col)) {
			unionFind.union(index, index-n);
		}
		if (row<n-1 && isOpen(row+1, col)) {
			unionFind.union(index, index+n);
		}
		if (col>0 && isOpen(row, col-1)) {
			unionFind.union(index, getIndex(row, col-1));
		}
		if (col<n-1 && isOpen(row, col+1)) {
			unionFind.union(index, getIndex(row, col+1));
		}
		
	}
	
	
	
	public boolean isOpen(int row, int col) {
		check(row, col);
		return grid[row][col];
	}
	
	public boolean isFull(int row, int col) {
		check(row, col);
		return unionFind.find(getIndex(row, col))==unionFind.find(0);
	}
	
	public int getIndex(int row, int col) {
		return (row)*n +col;
	}
	
	public void check(int row, int col) {
		if (row<n && col<n && row>=0 && col>=0) return;
		else throw new IllegalArgumentException();
	}
	
	public int numberOfOpenSites() {
		return openSites;
	}
	public boolean percolates() {
		return unionFind.find(top)==unionFind.find(bottom);
	}
	public static void main(String[] args) {
		
	}
}
