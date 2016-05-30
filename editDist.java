import java.util.*;
import java.lang.*;

public class editDist {
	/*Given two words A and B, find the minimum number of steps required to convert A to B.
	 *  (each operation is counted as 1 step.)
	 * You have the following 3 operations permitted on a word: Insert, delete, replace
	 */
	
	public int minDistance(String a, String b) {
		
		int T[][] = new int[b.length() +1][a.length() +1];
		for (int i = 0; i <= a.length(); i++)
			T[0][i] = i;
		for (int i = 0; i <= b.length(); i++)
			T[i][0] = i;
		
		for (int i = 1; i <= b.length(); i++){
			for (int j = 1; j <= a.length();  j++){
				if (a.charAt(j -1) != b.charAt(i -1))
					T[i][j] = Math.min(Math.min(T[i-1][j], T[i][j -1]), T[i -1][j -1]) +1;
				else
					T[i][j] = T[i -1][j -1];
			}
		}
		
		return T[b.length()][a.length()];
	}
	
	
	public static void main(String[] args) {
		System.out.println(new editDist().minDistance("Anshuman", "Antihuman"));
	}
}
