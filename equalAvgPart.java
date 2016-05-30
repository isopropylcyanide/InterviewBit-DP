import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class equalAvgPart {
	/*Given an array with non negative numbers, divide the array into two parts such that the average of both the 
	 * parts is equal. Return both parts (If exist). If there is no solution. return an empty list. * */
	
	static double avgT = 0;
	static boolean T[][][];
	ArrayList<Integer> res, orig;
	static int totalSize;
	
	public boolean subsetSum(int a[], int total) {
		//Find if any subset sums up to total
        boolean T[][] = new boolean[a.length + 1][total + 1];
        for (int i = 0; i <= a.length; i++) {
            T[i][0] = true;
        }

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j - a[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - a[i - 1]];
                } else {
                    T[i][j] = T[i-1][j];
                }
            }
        }
        return T[a.length][total];
    }

		
	
	public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		
		totalSize = a.size();
		Collections.sort(a);
		int totalSum = a.stream().mapToInt(Integer::intValue).sum();
		avgT = totalSum / (double)totalSize;

		T = new boolean[totalSize][totalSum + 1][totalSize];
		orig = a;
		res = new ArrayList<>();
		
		for (int i = 1; i < totalSize; i ++){
			if ((totalSum * i) % totalSize != 0)
				continue;
			int sumSetA = (totalSum * i) / totalSize;
			
			
		}
		
		
		return arrayList;
	}
	
	public static void main(String[] args) {
		System.out.println(new equalAvgPart().avgset(new ArrayList<>(Arrays.asList(1, 7, 15, 29 , 11, 9))));
		
		int t[] = {1, 7, 15, 29, 11, 9};
		System.out.println(new equalAvgPart().subsetSum(t, 13));
	
	}
	
}
