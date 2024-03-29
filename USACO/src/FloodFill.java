import java.util.*;
import java.io.*;
public class FloodFill {
	private static char[][] grid;
	private static int n, m;
	private static boolean[][] visited; 
	private static int currentSize = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("USACOinput1")));  
//		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    grid = new char[n][m];
	    visited = new boolean[n][m];
	    for (int i=0; i<n; i++) {
	    	String line = br.readLine();
	    	for (int j=0; j<m; j++) {
	    		grid[i][j] = line.charAt(j);
	    	}
	    }
	    ArrayList<ArrayList<Character>> allResults = new ArrayList<ArrayList<Character>>();
	    for(int i = 0; i < n; i++){
	        for(int j = 0; j < m; j++){
	            if(!visited[i][j]){
	                currentSize = 0;
	                ArrayList<Character> results = floodfill(i, j, grid[i][j], new ArrayList<Character>());
	                System.out.println(currentSize);
	                allResults.add(results);
	                System.out.println();
	                // start a floodfill if the square hasn't already been visited,
	                // and then store or otherwise use the component size
	                // for whatever it's needed for
	            }
	        }
	    }
	    for (int i=0; i<allResults.size(); i++) {
	    	if (allResults.get(i).get(0)=='.') {
	    		System.out.println("room");
	    	}
	    }
	}
	
	public static ArrayList<Character> floodfill(int r, int c, char color, ArrayList<Character> results) {
		if(r < 0 || r >= n || c < 0 || c >= m) return results; // if outside grid
	    if(grid[r][c] != color) return results; // wrong color
	    if(visited[r][c]) return results; // already visited this square
	    visited[r][c] = true; // mark current square as visited
	    results.add(grid[r][c]);
	    System.out.println(grid[r][c]);
	    currentSize++; // increment the size for each square we visit
	    // recursively call floodfill for neighboring squares
	    floodfill(r, c+1, color, results);
	    floodfill(r, c-1, color, results);
	    floodfill(r-1, c, color, results);
	    floodfill(r+1, c, color, results);
	    return results;
	}

}
