class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class maxSumTree {
	//	Given a binary tree, find the maximum path sum.The path may start and end at any node in the tree.
int maxFound;
	
	public maxSumTree() {
		maxFound = Integer.MIN_VALUE;
	}
	
	private int sumFinder(TreeNode a) {
		if (a == null)
			return 0;
		
		if (a.left == null && a.right == null){
			maxFound = Math.max(maxFound, a.val);
			return a.val;
		}
		
		int l = sumFinder(a.left);
		int r = sumFinder(a.right);
		int cross = l + r + a.val;
		int oneWay = Math.max(l, r) + a.val;
		maxFound = Math.max(maxFound, Math.max(cross, oneWay));
		maxFound = Math.max(maxFound, a.val);
		
		return oneWay;
		
	}
	
	public int maxPathSum(TreeNode a) {
		sumFinder(a);
		return maxFound;
	}
	
	public static void main(String[] args) {
		TreeNode aNode = new TreeNode(1);
		aNode.left = new TreeNode(2);
		aNode.right = new TreeNode(3);
		System.out.println(new maxSumTree().maxPathSum(aNode));
	}

}
