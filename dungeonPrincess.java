import java.util.*;
/*The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon
 consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room 
 and must fight his way through the dungeon to rescue the princess. The knight has an initial health point represented 
 by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.Some of the rooms 
 are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are
  either empty (0’s) or contain magic orb that increase the knight’s health (positive integers).In order to reach the 
  princess as quickly as possible, the knight decides to move only rightward or downward in each step. Write a function
   to determine the knight’s minimum initial health so that he is able to rescue the princess.
 * */

public class dungeonPrincess {
	
	public int calculateMinimumHP(ArrayList<ArrayList<Integer>> a) {
		int m = a.size(), n = a.get(0).size();
		
		for (ArrayList<Integer> arrayList : a)
			System.out.println(arrayList);
		System.out.println();
		
        int T[][] = new int[m][n];
        T[m -1][n -1] = Math.max(1 - a.get(m -1).get(n -1), 1);
        
        for (int i = m -2; i >= 0; i--)
        	T[i][n -1] = Math.max(T[i +1][n -1] - a.get(i).get(n -1), 1);

        for (int j = n -2; j >= 0; j--)
        	T[m -1][j] = Math.max(T[m -1][j +1] - a.get(m -1).get(j), 1);
        
        for (int i = m -2; i >= 0; i--){
        	for (int j = n -2; j >= 0; j--){
        		int down = Math.max(T[i +1][j] - a.get(i).get(j), 1);
        		int up = Math.max(T[i][j +1] - a.get(i).get(j), 1);
        		T[i][j] = Math.min(down, up);
        	}
        }
        
        for (int i = 0; i < m; i++){
        	for (int j = 0; j < n; j++)
        		System.out.print(T[i][j] + " ");
        	System.out.println();
        }
        
		
		return T[0][0];
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		arrayList.add(new ArrayList<>(Arrays.asList(-2, -3, 3)));
		arrayList.add(new ArrayList<>(Arrays.asList(-5, -10, 1)));
		arrayList.add(new ArrayList<>(Arrays.asList(10, 30, -5)));

		System.out.println(new dungeonPrincess().calculateMinimumHP(arrayList));
	}
}










