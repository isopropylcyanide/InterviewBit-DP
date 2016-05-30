
public class stairs {
//	ou are climbing a stair case. It takes n steps to reach to the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	
	int dp[];
	
	public int recStairs(int i, int n){
		if (i > n)
			return 0;
		if (i == n)
			return 1;
		if (dp[i] != -1)
			return dp[i];
		
		dp[i] = recStairs(i + 1, n) + recStairs(i + 2, n);
		return dp[i];
	}
	
	public int climbStairs(int a) {
		dp = new int[a + 1];
		for (int i = 0; i <= a; i++)
			dp[i] = -1;
		
		return recStairs(0, a);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new stairs().climbStairs(567));
	}

}
