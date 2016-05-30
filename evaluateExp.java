import java.util.*;



public class evaluateExp {
	/*Given expression with operands and operators (OR , AND , XOR) , in how many ways can you evaluate the
	 expression to true, by grouping in different ways? Operands are only true and false.*/
	
	class Pair{
		public int first;
		public int second;
		
		public Pair(int a, int b){
			this.first = a;
			this.second = b;
		}
		
		 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Pair)) return false;
	        Pair Pair = (Pair) o;
	        return first == Pair.first && second == Pair.second;
	    }

	    @Override
	    public int hashCode() {
	        int result = first;
	        result = 31 * result + second;
	        return result;
	    }
	}
	
	int mod = 1003;
	HashMap<Pair, Integer> _true, _false;
	
	public evaluateExp() {
		// TODO Auto-generated constructor stub
		_true = new HashMap<>();
		_false = new HashMap<>();
	}
	
	public int evTrue(int i, int j, char []a){
		//ways to return true
		if (i > j)
			return 0;
		
		if (i == j)
			return a[i] == 'T' ? 1 : 0;
		
		if (_true.containsKey(new Pair(i, j)))
			return _true.get(new Pair(i, j));
		
		int ans = 0;
		for (int k = i; k < j; k++){
			if (a[k] == '&')
				ans += evTrue(i, k - 1, a) * evTrue(k +1, j, a);
			
			if (a[k] == '|')
				ans += evTrue(i, k -1, a) * evTrue(k +1, j, a) + 
						evFalse(i, k -1, a) * evTrue(k +1, j, a) + evTrue(i, k -1, a) * evFalse(k +1, j, a);
			
			if (a[k] == '^')
				ans += evTrue(i, k -1, a) * evFalse(k +1, j,a) + evFalse(i, k -1, a) * evTrue(k +1, j, a);
			
			ans = (ans + mod) % mod;
		}
		
		_true.put(new Pair(i, j), ans);
		return _true.get(new Pair(i, j));
		
	}
	
	public int evFalse(int i, int j, char []a){
		//ways to return false
		if (i > j)
			return 0;
		
		if (i == j)
			return a[i] == 'F' ? 1 : 0;
		
		if (_false.containsKey(new Pair(i, j)))
			return _false.get(new Pair(i, j));
		
		int ans = 0;
		for (int k = i; k < j; k++){
			if (a[k] == '&')
				ans += evFalse(i, k -1, a) * evFalse(k +1, j, a) + 
						evFalse(i, k -1, a) * evTrue(k +1, j, a) + evTrue(i, k -1, a) * evFalse(k +1, j, a);
			
			if (a[k] == '|')
				ans += evFalse(i, k -1, a) * evFalse(k +1, j, a); 
			
			if (a[k] == '^')
				ans += evTrue(i, k -1, a) * evTrue(k +1, j,a) + evFalse(i, k -1, a) * evFalse(k +1, j, a);
			
			ans = (ans + mod) % mod;
		}
		
		_false.put(new Pair(i, j), ans);
		return _false.get(new Pair(i, j));
	}
	
	public int cnttrue(String a) {
		
		_true.clear();
		_false.clear();
		
		int n = a.length();
		
		return evTrue(0, n -1, a.toCharArray());
	}

	public static void main(String[] args) {
		System.out.println(new evaluateExp().cnttrue("T|F&T^T"));
	}
	
}
