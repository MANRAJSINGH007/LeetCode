class Solution {
    public int numJewelsInStones(String j, String s) {
        
        HashSet<Character> set=new HashSet<Character>();
        
        for(int i=0;i<j.length();i++){
            set.add(j.charAt(i));
        }
        
        int count=0;
        
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                count++;
            }
        }
        
        return count;
        
    }
}
