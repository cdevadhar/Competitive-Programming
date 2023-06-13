import java.util.*;
import java.io.*;
public class WordProcessor {
	
	public void fixFormat(ArrayList<String> essay, int K) {
		int count = 0;
		
 	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("USACOinput1"));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		ArrayList<String> essay = new ArrayList<String>();
		StringTokenizer line = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			String word = line.nextToken();
			System.out.print(word + " ");
			essay.add(word);
		}
		
		
		
	}
}
