import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class possPass {
	
	public static int lcs(String a, String b){
		int m = a.length(), n = b.length();
		
		int T[][] = new int[m +1][n +1];
		for (int i = 1; i <= m; i++){
			for (int j = 1; j <= n; j++){
				if (a.charAt(i -1) == b.charAt(j -1))
					T[i][j] = T[i -1][j -1] +1;
				else
					T[i][j] = Math.max(T[i -1][j], T[i][j -1]);
			}
		}
		
		return T[m][n];
	}
	
	public static boolean doubleFreq(String S, String P){
		Map<Character, Integer> fMap = new HashMap<Character, Integer>();
		Map<Character, Integer> pMap = new HashMap<Character, Integer>();
		
		boolean isDouble = true;
		
		for (int i = 0; i < S.length(); i++){
			char s = S.charAt(i);
			if (fMap.containsKey(s))
				fMap.put(s, fMap.get(s) +1);
			else
				fMap.put(s, 1);
		}
		
		for (int i = 0; i < P.length(); i++){
			char s = P.charAt(i);
			if (pMap.containsKey(s))
				pMap.put(s, pMap.get(s) +1);
			else
				pMap.put(s, 1);
		}
		
		for (Character mEntry : pMap.keySet()){
			int val = pMap.get(mEntry);
			if (val %2 == 1 || fMap.containsKey(mEntry) == false || fMap.get(mEntry) != val/2){
				isDouble = false;
				break;
			}
		}
		
		return isDouble;
	}
	
    public static String possiblePass(String S, String P){
        //Find if the password is possible. Conditions:
    	// Only if length of P is twice that of S
    	// LCS of S and P has length that of S
    	// Freq of letters are exactly twice in P with no extra letter
    	// Removing S from P yields P = S
    	int n = S.length(), nn = P.length();
    	if (nn != 2 * n)
    		return "Impossible";
    	
    	if (!P.contains(S))
    		return "Impossible";
    	
    	if (lcs(S, P) != n)
    		return "Impossible";
    	
        if (!doubleFreq(S, P))
        	return "Impossible";
        
        P = P.replaceFirst(S, "");
        if (!P.equals(S))
        	return "Impossible";
        
    	return "Possible";
    }


    public static void main(String args[] ) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testcases = Integer.parseInt(line);
        
        while (testcases-- > 0){
        	String a[] = br.readLine().split(" ");
        	String S = a[0], P = a[1]; 
        	
            System.out.println(possiblePass(S, P));
        }

    }
}
