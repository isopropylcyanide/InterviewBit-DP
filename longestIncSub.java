import java.util.*;

public class longestIncSub {
	//Find the longest increasing subsequence of a given sequence / array. 
	
	public int lis(final List<Integer> a) {
		int n = a.size();
		
		int T[]= new int[n];
		
		for (int i = 0; i < n; i++)
			T[i] = 1;
		
		for (int i = 1; i < n; i++){
			for (int j = 0; j < i; j++){
				if (a.get(j) < a.get(i))
					T[i] = Math.max(T[j] + 1, T[i]);
			}
		}
		int maximum = T[0];
		
		for (int i = 0; i < n; i++)
        	maximum = T[i] > maximum ? T[i] : maximum;
		
		return maximum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new longestIncSub().lis(Arrays.asList(3, 4, -1, 0 ,6 ,2, 3)));
	}

}
