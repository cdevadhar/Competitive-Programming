package labs_projects;
import java.util.Arrays;

public class Hello
{
    public static void main(String[] args) {
    	for (int i=0; i<10; i++) {
    		int streak = 0;
        	for (int j=0; j<30; j++) {
        		double shot = Math.random();
        		if (shot<0.6) {
        			streak++;
        		}
        		else streak=0;
        		if (streak>=7) break;
        	}
        	System.out.println(streak);
    	}
    	
    }
}
