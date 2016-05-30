import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class maxRectMat {
	/*Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and 
	 * return its area. Bonus if you can solve it in O(n^2) or less.
	 * */
	
	public int maxAreaInHistogram(int []a){
		
		Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for(i=0; i < a.length;){
            if(stack.isEmpty() || a[stack.peekFirst()] <= a[i]){
                stack.offerFirst(i++);
            }else{
                int top = stack.pollFirst();
                if(stack.isEmpty()){
                    area = a[top] * i;
                }
                else
                    area = a[top] * (i - stack.peekFirst() - 1);
                maxArea = Math.max(area, maxArea);
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pollFirst();
            if(stack.isEmpty())
                area = a[top] * i;
            else
                area = a[top] * (i - stack.peekFirst() - 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
	}
	
	public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
		int n = a.size();
		if (n < 1 || a == null)
			return 0;
		
		int m = a.get(0).size();
		int T[] = new int[m];
		int maxSoFar = 0;
		
		for (int i = 0; i < n; i++){
			for (int j = 0; j < m; j++)
				T[j] = a.get(i).get(j) == 0 ? 0 : T[j] + 1;
			
			maxSoFar = Math.max(maxSoFar, maxAreaInHistogram(T));
		}
		
		return maxSoFar;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		arrayList.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
		arrayList.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
		arrayList.add(new ArrayList<>(Arrays.asList(1, 0, 0)));
		
		System.out.println(new maxRectMat().maximalRectangle(arrayList));
	}

}
