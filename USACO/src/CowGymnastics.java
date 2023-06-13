import java.io.*;
import java.util.*;

public class CowGymnastics {
	
	public boolean onlyMutation(ArrayList<String> normal, ArrayList<String> mutated, int position) {
		ArrayList<ArrayList<String>> acceptableCharacters = new ArrayList<ArrayList<String>>();
		boolean isItMutation = true;
		for (int i=0; i<normal.size(); i++) {
			for (int j=0; j<mutated.size(); j++) {
				if (normal.get(i).charAt(position) == mutated.get(j).charAt(position)) {
					isItMutation = false;
				}
			}
		}
		return isItMutation;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("USACOinput1"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bovineGenomics.out")));
		
		String line1 = br.readLine();
		
		StringTokenizer st = new StringTokenizer(line1);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<String> spottyGenomes = new ArrayList<String>();
		for (int i=0; i<n; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			String spottyCow = str.nextToken();
			spottyGenomes.add(spottyCow);
			System.out.println(spottyCow);
		}
		ArrayList<String> plainGenomes = new ArrayList<String>();
		for (int i=0; i<n; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			String plainCow = str.nextToken();
			plainGenomes.add(plainCow);
			System.out.println(plainCow);
		}
		int numberToPrint = 0;
		
		for (int i=0; i<m; i++) {
			boolean mutationTest = new CowGymnastics().onlyMutation(plainGenomes, spottyGenomes, i);
			if (mutationTest == true) {
				numberToPrint ++;
			}
		}
		System.out.println(numberToPrint);
		
		
		
	}
	

}
