import java.util.*;

public class bestTimeStocks {
	
	public int maxProfitBuyOnce(final List<Integer> a) {
		//If you were only permitted to complete at most one transaction Restriction. Must buy before selling
	    int cur = 0, max = 0;
	    for (int i = 1; i < a.size(); i++){
	    	cur = a.get(i)- a.get(i- 1) + Math.max(cur, 0);
	    	max = Math.max(max, cur);
	    }
	    return max;
	}

	public int maxProfitMultiple(final List<Integer> a) {
		//Buy and sell multiple times. Buy before selling. One at hand always
		int n = a.size();
		if (n <= 1)
			return 0;
		
		int T [] = new int[n];
		T[0] = 0;
		
		for (int i = 1; i < n; i++){
			if (a.get(i) > a.get(i -1))
				T[i] = a.get(i) - a.get(i -1) + T[i -1];
			else
				T[i] = T[i -1];
		}
		
		return T[n -1];
	}
	
	public int maxProfit(final List<Integer> a) {
		//At most 2 transactions. Replace  by k
		int n = a.size();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = a.get(i);
		
		if (n <= 1)
			return 0;
		
		int T[][] = new int[2 + 1][n];
				
		for (int i = 1; i <= 2; i++){
			int maxDiff = -A[0];
			for (int j = 1; j < n; j++){
				T[i][j] = Math.max(T[i][j -1], A[j] + maxDiff);
				maxDiff = Math.max(maxDiff, T[i -1][j] - A[j]);
				
			}
		}
		return T[2][n -1];
	}
	
	
	public static void main(String[] args) {
		System.out.println(new bestTimeStocks().maxProfit(Arrays.asList(2, 5, 7 ,1, 4, 3, 1, 3)));
	}
}
