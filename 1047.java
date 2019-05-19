class Solution {
    public String removeDuplicates(String str) {
        
        int n=str.length();
        Stack<Character> stack=new Stack<>();
        
        for(int i=0;i<n;i++){
            char curr=str.charAt(i);
            int flag=0;
            while(stack.size()>0 && stack.peek()==curr){
                stack.pop();
                flag=1;
            }
            if(flag==0){
                stack.push(curr);
            }
        }
        
        String ans="";
        while(stack.size()>0){
            ans=stack.pop()+ans;
        }
        
        return ans;
        
    }
}
