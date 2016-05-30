

public class minPathMatrix {
	//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right 
	//which minimizes the sum of all numbers along its path. Move either down or right at any point in time.
	
	public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
		
        int T[][] = new int[m][n];
        T[0][0] = grid[0][0];
        
        for (int j = 1; j < n; j++)
        	T[0][j] = grid[0][j] + T[0][j -1];
        
        for (int i = 1; i < m; i++)
        	T[i][0] = grid[i][0] + T[i -1][0];
        
        for (int i = 1; i < m; i++)
        	for (int j = 1; j < n; j++)
        		T[i][j] = grid[i][j] + Math.min(T[i -1][j], T[i][j -1]);
        
        for (int i = 0; i < m; i++){
        	for (int j = 0; j < n; j++)
        		System.out.print(T[i][j] + " ");
        	System.out.println();
        }
        
        return T[m -1][n -1];
        
    }

	public static void main(String[] args) {
		int grid[][] = {
		            {1, 3, 5, 8},
		            {4, 2, 1, 7},
		            {4, 3, 2, 3}
		};
		
		
		System.out.println(new minPathMatrix().minPathSum(grid));
		
	}

}
