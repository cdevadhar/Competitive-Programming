import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class PercolationStats {
	private double[] fractions;
	private int trials;
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int t = Integer.parseInt(args[1]);
		PercolationStats test = new PercolationStats(n, t);
		
	}
	
	public PercolationStats(int n, int trials) {
		if (n<=0 || trials<=0) throw new IllegalArgumentException();
		fractions = new double[trials];
		this.trials = trials;
		for (int i=0; i<trials; i++) {
			Percolation perc = new Percolation(n);
			int opened = 0;
			while (!perc.percolates()) {
				int x = StdRandom.uniform(0, n);
				int y = StdRandom.uniform(0, n);
				if (!perc.grid[x][y]) {
					perc.open(x, y);
					opened++;
				}
			}
			fractions[i] = ((double)opened)/n*n;
			
		}
	}
	
	public double mean() {
		return StdStats.mean(fractions);
	}
	
	public double stddev() {
		return StdStats.stddev(fractions);
	}
	
	public double confidenceLo() {
		return mean() - 1.96*stddev()/Math.sqrt(trials);
	}
	
	public double confidenceHi() {
		return mean() + 1.96*stddev()/Math.sqrt(trials);
	}
}
