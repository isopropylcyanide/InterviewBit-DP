import java.util.Stack;

public class longestValPar {
	/*Given a string containing just the characters '(' and ')', find the length of the longest 
	 * valid (well-formed) parentheses substring.
	 */
	
	public int longestValidParentheses(String a) {
		Stack<Integer> s = new Stack<>();
		s.push(-1);
		int ans = 0;

		for (int i = 0; i < a.length(); i++){
			if (a.charAt(i) == '(')
				s.push(i);
			else{
				s.pop();
				if (!s.empty())
					ans = Math.max(ans, i - s.peek());
				else
					s.push(i);
			}
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new longestValPar().longestValidParentheses("(()()"));
	}

}
