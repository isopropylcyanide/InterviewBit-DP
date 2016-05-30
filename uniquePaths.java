import java.util.*;

public class uniquePaths {
	/*Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n).
	 *  At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).
	 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
		An obstacle and empty space is marked as 1 and 0 respectively in the grid.
	 */
	int n, m;
	int dp[][];
	
	public int rec(int i, int j, ArrayList<ArrayList<Integer>> a){
		if (i >= m || j >= n || a.get(i).get(j) == 1)
			return 0;
		if (i == m - 1 && j == n - 1 && a.get(i).get(j)!= 1)
			return 1;
		if (dp[i][j] != -1)
			return dp[i][j];
		
			dp[i][j] = rec(i, j + 1, a) + rec(i + 1, j, a);
		return dp[i][j];
	}
	
	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
		
		m = a.size();
		n = a.get(0).size();
		dp = new int[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				dp[i][j] = -1;
		return rec(0, 0, a);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		arrayList.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
		arrayList.add(new ArrayList<>(Arrays.asList(0, 1, 0)));
		arrayList.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
		
		System.out.println(new uniquePaths().uniquePathsWithObstacles(arrayList));
	}

}
