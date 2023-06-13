import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
public class RandomWord {
	public static void main(String[] args) {
		String champion = "";
		double count = 1.0;
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			
			if (StdRandom.bernoulli(1/count)) champion = s;
			count++;
		}
		System.out.println(champion);
	}
}