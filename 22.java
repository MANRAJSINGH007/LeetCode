public class Solution {
    
  	public static void printParenthesis(int n, int opening, int closing, String ans,  List<String> list){
      
      if(closing==n){
        
        list.add(ans);
        return ;
        
      }
      
      if(opening==n){
        
        printParenthesis(n,opening,closing+1,ans+')',list);
        return ;
        
      }
      
      if(opening==closing){
        
        printParenthesis(n,opening+1,closing,ans+'(',list);
        return ;
        
      }
      
      
      printParenthesis(n,opening+1,closing,ans+'(',list);
      printParenthesis(n,opening,closing+1,ans+')',list);
      
      return ;
      
    }
	
	public static List<String> generateParenthesis(int n){
      
      List<String> list=new ArrayList<>();
      printParenthesis(n,0,0,"",list);
      return list;

	}
	
}
