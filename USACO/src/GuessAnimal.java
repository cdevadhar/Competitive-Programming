import java.util.*;
import java.io.*;

public class GuessAnimal {
	
	public void numInCommon(ArrayList<Animal> animals) {
		ArrayList<Integer> numsCommon = new ArrayList<Integer>();
		for (int i=0; i<animals.size(); i++) {
			for (int j=0; j<animals.size(); j++) {
				if (i!=j) {
					ArrayList<String> commonChars = new ArrayList<String>(animals.get(i).characteristics);
					commonChars.retainAll(animals.get(j).characteristics);
					int numCommon = commonChars.size();
					numsCommon.add(numCommon);
				}
				
			}
		}
		int max = Collections.max(numsCommon) + 1;
		System.out.println(max);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("USACOinput1"));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		ArrayList<Animal> Animals = new ArrayList<Animal>();
		
		for (int i=0; i<N; i++) {
			StringTokenizer str1 = new StringTokenizer(br.readLine());
			String name = str1.nextToken();
			int k = Integer.parseInt(str1.nextToken());
			ArrayList<String> characteristics = new ArrayList<String>();
			for (int j=0; j<k; j++) {
				String characteristic = str1.nextToken();
				characteristics.add(characteristic);
				
			}
			Animal newAnimal = new Animal(characteristics, name);
			Animals.add(newAnimal);
			
		}
		
		new GuessAnimal().numInCommon(Animals);
		
		
	}

}

class Animal {
	String name;
	ArrayList<String> characteristics;
	public Animal(ArrayList<String> characteristics, String name) {
		this.characteristics = characteristics;
		this.name = name;
	}
}
