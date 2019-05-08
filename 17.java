class Solution {
    
    public static List<String> func(String str, int n, int i, HashMap<Character,String> map, HashMap<Integer,List<String>> dp){
        
        if(i==n){
            List<String> temp=new ArrayList<>();
            temp.add("");
            return temp;
        }
        
        if(dp.containsKey(i)){
            return dp.get(i);
        }
        
        char ch=str.charAt(i);
        String possible=map.get(ch);
        List<String> curr=new ArrayList<>();
        List<String> small=func(str,n,i+1,map,dp);
        
        for(int k=0;k<possible.length();k++){
            char cc=possible.charAt(k);
            for(int p=0;p<small.size();p++){
                curr.add(cc+small.get(p));
            }
        }
        
        dp.put(i,curr);
        return curr;
        
    }
    
    
    public List<String> letterCombinations(String digits) {
        
        if(digits.length()==0){
            return new ArrayList<>();
        }
        
        HashMap<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        HashMap<Integer,List<String>> dp=new HashMap<>();
        return func(digits,digits.length(),0,map,dp);
    }
}
