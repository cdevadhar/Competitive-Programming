import java.io.*;
import java.util.*;
public class Taxi {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    st = new StringTokenizer(br.readLine());
	    
	    int[] nums = new int[4];
	    for (int i=0; i<n; i++) {
	    	nums[Integer.parseInt(st.nextToken())-1]++;
	    }
	    int taxis = nums[3];
	    taxis+=nums[1]/2;
	    if (nums[1]%2==0) {
	    	nums[1]=0;
	    }
	    else nums[1]=1;
	    int pairs = Math.min(nums[0], nums[2]);
	    taxis+=(pairs);
	    if (nums[0]>nums[2]) {
	    	nums[0]-=nums[2];
	    	if (nums[1]==0) taxis+=Math.ceil((double)nums[0]/4);
	    	else {
	    		taxis++;
	    		if (nums[0]>2) taxis+=Math.ceil((double)(nums[0]-2)/4);
	    	}
	    }
	    else {
	    	nums[2]-=nums[0];
	    	taxis+=nums[2]+nums[1];
	    }
	    System.out.println(taxis);
	    
	}
}
