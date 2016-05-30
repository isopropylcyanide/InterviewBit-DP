import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class wordBreakII {
	//Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word
	//	is a valid dictionary word. Return all such possible sentences.
	
	public void dfs(ArrayList<String>[] dp,int end,ArrayList<String> result, ArrayList<String> tmp){
	    if(end <= 0){
	        String path = tmp.get(tmp.size()-1);
	        for(int i=tmp.size()-2; i>=0; i--){
	            path += " " + tmp.get(i) ;
	        }
	 
	        result.add(path);
	        return;
	    }
	 
	    for(String str : dp[end]){
	        tmp.add(str);
	        dfs(dp, end-str.length(), result, tmp);
	        tmp.remove(tmp.size()-1);
	    }
	}
	
	public ArrayList<String> wordBreak(String s, ArrayList<String> dict) {
		//create an array of ArrayList<String>
		Set<String> foo = new HashSet<>(dict);
	        ArrayList<String> dp[] = new ArrayList[s.length()+1];
	        dp[0] = new ArrayList<String>();
	     
	        for(int i=0; i<s.length(); i++){
	            if( dp[i] == null ) 
	                continue; 
	     
	            for(String word:foo){
	                int len = word.length();
	                int end = i+len;
	                if(end > s.length()) 
	                    continue;
	     
	                if(s.substring(i,end).equals(word)){
	                    if(dp[end] == null){
	                        dp[end] = new ArrayList<String>();
	                    }
	                    dp[end].add(word);
	                }
	            }
	        }
	     
	        ArrayList<String> result = new ArrayList<String>();
	        if(dp[s.length()] == null) 
	            return result; 
	     
	        ArrayList<String> temp = new ArrayList<String>();
	        dfs(dp, s.length(), result, temp);
	        Collections.sort(result);
	        return result;
	    }
	    
	 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> dict = new ArrayList<>(Arrays.asList("cat","cats","and","sand","dog"));
		System.out.println(new wordBreakII().wordBreak("catsanddog", dict));
	}

}
