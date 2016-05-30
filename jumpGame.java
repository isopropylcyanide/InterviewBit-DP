import java.util.*;

public class jumpGame {
	/*Given an array of non-negative integers, you are initially positioned at the first index of the array.
		Each element in the array represents your maximum jump length at that position.
		Determine if you are able to reach the last index*/
	
	public int jumpDP(ArrayList<Integer> a){
		//Minimum jump to reach from start to end, else INT_MAX
		int n = a.size();
		int J[] = new int[n];
		for (int i = 0; i < n; i++)
			J[i] = Integer.MAX_VALUE;
		
		J[0] = 0;
		
		for (int i = 1; i < n; i++){
			for (int j = 0; j < i; j++){
				if (a.get(j) + j >= i)
					J[i] = Math.min(J[i], J[j]+ 1);
			}
		}
		
		return J[n -1] == Integer.MAX_VALUE ? -1 : J[n -1];
	}
	
	public int jump(ArrayList<Integer> A){
		//Minimum jump to reach from start to end, else -1 GREEDY
		if (A == null || (A.size() > 1 && A.get(0) == 0))
	        return -1;
	    
		int n = A.size();
		
		int ladder = A.get(0); //largest ladder you have
		int stairs = A.get(0); //stairs remaining in my largest ladder
		
		int jump = 1;
		for (int i = 1; i < n; i++){
			if (i == n -1)
				return jump;
			if ( i + A.get(i) > ladder)
				ladder = i + A.get(i);
			stairs --; //use one stair
			if (stairs == 0){
				jump ++;
				stairs = ladder - i;
			}
		}
	    
		return jump;
	}
	
	
	public int canJump(ArrayList<Integer> a) {
		if(a.size() <= 1)
	        return 1;
	 
	    int max = a.get(0); //max stands for the largest index that can be reached.
	 
	    for(int i=0; i<a.size(); i++){
	        //if not enough to go to next
	        if(max <= i && a.get(i) == 0) 
	            return 0;
	 
	        //update max    
	        if(i + a.get(i) > max){
	            max = i + a.get(i);
	        }
	 
	        //max is enough to reach the end
	        if(max >= a.size()-1) 
	            return 1;
	    }
	    return 0;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new jumpGame().jump(new ArrayList<Integer>(Arrays.asList(2, 3, 1, 1, 4 ))));
	}

}
