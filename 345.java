class Solution {
    public String reverseVowels(String s) {
        
        if(s==null){
            return null;
        }
        
        HashSet<Character> set=new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        
        char arr[]=s.toCharArray();
        int n=s.length();
        int start=0;
        int end=n-1;
        String ans="";
        
        while(start<end){
            
            while(start<end && !set.contains(arr[start])){
                start++;
            }
            while(end>start && !set.contains(s.charAt(end))){
                end--;
            }
            
            if(start<end){
                char temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
        }
        
        return new String(arr);
        
    }
}
