import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class gift1 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("USACOinput1");
		Scanner input = new Scanner(file);
		int NP = Integer.parseInt(input.nextLine());
		ArrayList<String> names = new ArrayList<String>();
		for (int i=0; i<NP; i++) {
			names.add(input.nextLine());
		}
		
	}

}
