import java.util.*;

class Pair<A, B>{
	public A first;
	public B second;
	
	public Pair(A a, B b){
		this.first = a;
		this.second = b;
	}

}

public class coinsInLine {
	
	/*There are N coins (Assume N is even) in a line. Two players take turns to take a coin from one of the 
	 * ends of the line until there are no more coins left. The player with the larger amount of money wins.
	 *  Assume that you go first. Compute the maximum amount of money you can win.*/
	
	
	public int maxcoinRecursive(List<Integer> l) {
		int n = l.size();
		
		@SuppressWarnings("rawtypes")
		Pair[][] T = new Pair[n][n];
		
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++)
				if (i == j)
					T[i][j] = new Pair<Integer, Integer>(l.get(i), 0);
				else
					T[i][j] = new Pair<Integer, Integer>(0, 0);
		}

		for (int col = 1; col < n; col++){
			for (int i = 0; i < n - col; i++){
				int j = i + col;
				
				
				if (l.get(i) + (int)T[i+1][j].second > l.get(j) + (int)T[i][j -1].second){
					T[i][j].first = l.get(i) + (int) T[i+1][j].second;
					T[i][j].second = (int) T[i +1][j].first;
				}
				else{
					T[i][j].first = l.get(j) + (int) T[i][j -1].second;
					T[i][j].second = (int) T[i][j -1].first;
				}
			}
		}
		
		
		return (int) T[0][n -1].first;
	}
	
	public static void main(String[] args) {
		System.out.println(new coinsInLine().maxcoinRecursive(Arrays.asList(1,2,100,4)));
	}

}
