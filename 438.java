class Solution {
    
    public static boolean check(HashMap<Character,Integer> map, int[] arr){
        
        Set<Character> keys=map.keySet();
        for(Character ch: keys){
            int freq=map.get(ch);
            if(arr[(int)ch-97]!=freq){
                return false;
            }
        }
        
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) {
        
        if(s==null){
            return new ArrayList<>();
        }
        
        int m=p.length();
        int n=s.length();
        if(n<m){
            return new ArrayList<>();
        }
        
        int arr[]=new int[26];
        for(int i=0;i<m;i++){
            int num=(int)p.charAt(i)-97;
            arr[num]++;
        }
        
        HashMap<Character,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        
        for(int i=0;i<m;i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                int count=map.get(ch);
                count++;
                map.put(ch,count);
            }
            else{
                map.put(ch,1);
            }
        }
        
        int start=0;
        int end=m-1;
        while(true){
            if(check(map,arr)){
                list.add(start);
            }
            
            int count=map.get(s.charAt(start));
            count--;
            map.put(s.charAt(start),count);
            end++;
            start++;
            if(end==n){
                break;
            }
            if(map.containsKey(s.charAt(end))){
                count=map.get(s.charAt(end));
                count++;
                map.put(s.charAt(end),count);
            }
            else{
                map.put(s.charAt(end),1);
            }
            
        }
        
        return list;
    
    }
}
