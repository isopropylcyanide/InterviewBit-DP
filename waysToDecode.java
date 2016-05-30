public class waysToDecode {
	//Given an encoded message containing digits, determine the total number of ways to decode it.
	
	public int numDecodings(String a) {
		int n = a.length();
		int T[] = new int[n +1];
		
		T[0] = T[1] = 1;
		if (a.charAt(0) == '0')
			T[1] = 0;
		
		for (int i = 2; i <= n; i++){
			T[i] = 0;
			if (a.charAt(i -1) > '0')
				T[i] = T[i -1];
			
			if (a.charAt(i -2) <= '2' && a.charAt(i -1) < '7')
				T[i] = T[i] + T[i -2]; 
			
		}
		
		return T[n];
	}
	
	public static void main(String[] args) {
		System.out.println(new waysToDecode().numDecodings("0"));
	}

}
