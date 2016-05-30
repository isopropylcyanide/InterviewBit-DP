import java.util.ArrayList;
import java.util.Arrays;

public class wordBreakProb {
	//Given a string s and a dictionary of words, determine if s can be segmented
	//into a space-separated sequence of one or more dictionary words.

	public int wordBreak(String a, ArrayList<String> b) {
		int n = a.length();
		int T[][] = new int[n][n];

		for (int col = 0; col < n; col++){
			for (int i = 0; i < n - col; i++){
				int j = i + col;
				System.out.print("["+i+"]["+j+"]");
				String str = a.substring(i, j +1);
				System.out.print(": " + str);

				if (b.contains(str)){
					T[i][j] = 1;
					System.out.println("\tyes whole");
					continue;
				}
				//find a split point
				for (int k = i + 1; k <= j; k++)
					if (T[i][k -1] == 1 && T[k][j] == 1){
						System.out.println("\tyes split at "+ k);
						T[i][j] = 1;
						break;
					}
				if (T[i][j] == 0)
					System.out.println("\t None");
			}
		}

		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++)
				System.out.print(T[i][j] + " ");
			System.out.println();
		}

		return T[0][n -1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> dict = new ArrayList<>(Arrays.asList("cat","cats","and","sand","dog"));
		System.out.println(new wordBreakProb().wordBreak("catsanddog", dict));
	}

}
