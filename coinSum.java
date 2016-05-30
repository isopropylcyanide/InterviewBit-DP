import java.util.*;
import java.io.*;

public class coinSum {
	//You are given a set of coins S. In how many ways can you make sum N assuming
	//you have infinite amount of each coin in the set.
	
	public int coinchange2(ArrayList<Integer> a, int b) {
		int mod = 1000007;
		Collections.sort(a);

		int T[][] = new int[a.size() + 1][b +1];
		

		for (int i = 0; i <= a.size(); i++)
			T[i][0] = 1;
		
			
		for (int i = 1; i <= a.size(); i++){
			for (int j = 1; j <= b; j++){
				if (j < a.get(i -1))
					T[i][j] = T[i -1][j];

				else
					T[i][j] = (T[i -1][j] + T[i][j - a.get(i -1)]) % mod;
			}
		}
			
		return T[a.size()][b];
    }
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		ArrayList<Integer> t = new ArrayList<>(Arrays.asList(2, 5, 3, 6));
		System.out.println(new coinSum().coinchange2(t, 10));
	}

}
