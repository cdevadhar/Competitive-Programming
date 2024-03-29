import java.util.*;
import java.io.*;
public class NewWord {
	static int t;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    t = Integer.parseInt(st.nextToken());
	    for (int i=0; i<t; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int n = Integer.parseInt(st.nextToken());
	    	int l = Integer.parseInt(st.nextToken());
	    	System.out.println(n + " " + l);
	    	ArrayList<String> words = new ArrayList<String>();
	    	ArrayList<HashSet<Character>> tiles = new ArrayList<HashSet<Character>>();
	    	for (int j=0; j<l; j++) {
	    		tiles.add(new HashSet<Character>());
	    		System.out.println("added");
	    	}
	    	
	    	for (int k=0; k<n; k++) {
	    		st = new StringTokenizer(br.readLine());
	    		String s = st.nextToken();
	    		System.out.println(s);
	    		words.add(s);
	    		for (int x=0; x<s.length(); x++) {
	    			Character ch = s.charAt(x);
	    			tiles.get(x).add(ch);
	    		}
	    	}
	    	newWord(tiles, words);
	    	
	    }
	}
	
	public static void newWord(ArrayList<HashSet<Character>> tiles, ArrayList<String> words) {
		for (Character c: tiles.get(0)) {
			for (Character d: tiles.get(1)) {
				String word = c+""+d;
				if (!words.contains(word)) System.out.println(word);
			}
		}
	}
}
