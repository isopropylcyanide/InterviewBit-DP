import java.util.*;


public class minSumPathTria {
	//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent 
	//numbers on the row below.
	
	public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
		int T[] = new int[a.size()];
		
		for (int i = 0; i < a.get(a.size() -1).size(); i++)
			T[i] = a.get(a.size() -1).get(i);
		
		for (int i = a.size() -2; i >= 0; i--){
			for (int j = 0; j < a.get(i +1).size() -1; j++)
				T[j] = a.get(i).get(j) + Math.min(T[j], T[j + 1]);
		}
		
		return T[0];
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arrayList  = new ArrayList<>();
		arrayList.add(new ArrayList<>(Arrays.asList(2)));
		arrayList.add(new ArrayList<>(Arrays.asList(3, 4)));
		arrayList.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
		arrayList.add(new ArrayList<>(Arrays.asList(4, 14, 20, 1)));
		
		System.out.println(new minSumPathTria().minimumTotal(arrayList));
		
	}

}
