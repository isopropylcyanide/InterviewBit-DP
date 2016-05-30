import java.util.*;

public class maxProductSub {
	//Find the contiguous sub array within an array (containing at least one number) which has the largest product.
	//Return an integer corresponding to the maximum product possible.
	
	public int maxProduct(final List<Integer> a) {
		if(a == null || a.size() == 0)  
	        return 0;  
	 
	    int maxLocal = a.get(0);  
	    int minLocal = a.get(0);  
	    int global = a.get(0);  
	 
	    for(int i=1; i<a.size(); i++){  
	        int temp = maxLocal;  
	        maxLocal = Math.max(Math.max(a.get(i) * maxLocal, a.get(i)), a.get(i)*minLocal);  
	        minLocal = Math.min(Math.min(a.get(i) * temp, a.get(i)), a.get(i) * minLocal);  
	        global = Math.max(global, maxLocal);  
	    }  
	    return global;
	}

	
	public static void main(String[] args) {
		
		System.out.println(new maxProductSub().maxProduct(Arrays.asList(1, -2, -3, 0, 7, -8, -2)));
		
	}
}








