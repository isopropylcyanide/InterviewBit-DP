import java.util.*;

public class maxSumWithoutAdj {
	//Given a 2 * N Grid of numbers, choose numbers such that the sum of the numbers
	//is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.
	
	public int adjacent(ArrayList<ArrayList<Integer>> a) {
		int m = a.size();
		int n = a.get(0).size();
		
		int dp[] = new int[n];
		
		dp[0] = Math.max(a.get(0).get(0), a.get(1).get(0));
		if (n == 1)
			return dp[0];
		
		dp[1] = Math.max(a.get(0).get(1), a.get(1).get(1));
		dp[1] = Math.max(dp[0], dp[1]);
		
		if (n == 2)
			return dp[1];
		
		for (int i = 2; i < n; i++){
			dp[i] = 0;
			int include = dp[i -2] + Math.max(a.get(0).get(i), a.get(1).get(i));
			int exclude = dp[i -1];
			
			dp[i] = Math.max(include, exclude);
		}
		
		return dp[n -1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList <Integer> > arrayList = new ArrayList<>();
		arrayList.add(new ArrayList<>(Arrays.asList(1, 2, 3 ,4)));
		arrayList.add(new ArrayList<>(Arrays.asList(2, 3, 4, 5)));
		
		System.out.println(new maxSumWithoutAdj().adjacent(arrayList));

	}

}















