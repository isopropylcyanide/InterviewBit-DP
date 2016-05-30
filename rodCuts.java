import java.util.ArrayList;
import java.util.Arrays;
import java.util.prefs.BackingStoreException;

public class rodCuts {
//	 Return an array denoting the sequence in which you will make cuts. If two different sequences of cuts 
//	give same cost, return the lexicographically smallest
	public ArrayList<Integer> ar, ans;
	public long dp[][];
	public int parent[][], n;
	
	public long rec(int l, int r){
		if (l +1 >= r)
			return 0;
		
		long ret = dp[l][r];
		int bestind = 0;
		if (ret != -1)
			return ret;
		
		ret = Long.MAX_VALUE;
		for (int i = l + 1; i < r; i++){
			long p = rec(l, i) + rec(i, r) + ar.get(r) - ar.get(l);
			if (p < ret){
				bestind = i;
				ret = p;
			}
		}
		parent[l][r] = bestind;
		dp[l][r] = ret;
		return ret;
	}
	
	public void back(int l, int r){
		if (l + 1 >= r)
			return;
		ans.add(ar.get(parent[l][r]));
		back(l, parent[l][r]);
		back(parent[l][r], r);
	}
	
	public ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {
		B.add(0, 0);
		B.add(B.size(), A);
		
		n = B.size();
		ar = new ArrayList<>();
		ans = new ArrayList<>();
		dp = new long[n][n];
		parent = new int[n][n];
		
		ar.clear();
		ar.addAll(B);
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				dp[i][j] = -1;
		
		rec(0, n -1);
		back(0, n -1);
		
		return ans;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new rodCuts().rodCut(6, new ArrayList<>(Arrays.asList(1,2, 5))));
	}

}
