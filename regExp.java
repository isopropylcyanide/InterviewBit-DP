import java.util.regex.Pattern;

public class regExp {
//	Implement regular expression matching with support for '.' and '*'.
	
	public static int isMatchReg(final String s, final String p) {
		
		Pattern pattern = Pattern.compile(p);
		return pattern.matcher(s).find() ? 1 : 0;
	}
	
	public static int isMatch(final String s, final String p) {
		int n = s.length();
		int m = p.length();
		
		boolean[][] d = new boolean[n + 1][m + 1];
	    d[0][0] = true;
	    
	    for (int i = 0; i < m; ++i) {
	        char current = p.charAt(i);
	        if (current == '*') {
	            for (int j = 0; j < n; ++j) {
	                d[j + 1][i + 1] = d[j + 1][i - 1];
	            }
	            for (int j = 0; j < n; ++j) {
	                if ((p.charAt(i - 1) == '.') || (p.charAt(i - 1) == s.charAt(j))) {
	                    d[j + 1][i + 1] = d[j + 1][i + 1] || d[j][i - 1] || d[j][i + 1];
	                }
	            }
	        } else if (current == '.') {
	            for (int j = n - 1; j >= 0; --j) {
	                d[j + 1][i + 1] = d[j][i];
	            }
	        } else {
	            for (int j = 0; j < n; ++j) {
	                if (s.charAt(j) == p.charAt(i)) {
	                    d[j + 1][i + 1] = d[j][i];
	                }
	            }
	        }
	    }
	    

	    for (int i = 0; i <= n; i++){
	        for (int j = 0; j <= m; j++)
	            System.out.print((d[i][j] == false ? 0 : 1) + " ");
	        System.out.println();
	    }

	    
	    return d[n][m] ? 1 : 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("aab", "c*a*b*"));
	}

}
