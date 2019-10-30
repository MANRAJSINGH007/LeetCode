class Solution {
    
    public static int search(int index, ArrayList<Integer> list, int start, int end){
        
        int min = end + 1;
        int n = end + 1;
        
        while(start <= end){
            int mid = (start + end)/2;
            if(list.get(mid) <= index) start = mid + 1;
            else{
                min = Math.min(min, mid);
                end = mid - 1;
            }
        }
        
        if(min == n) return -1;
        return list.get(min);
    }
    
    public int numMatchingSubseq(String S, String[] words) {
        
        int n = S.length();
        
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            if(!map.containsKey(S.charAt(i))) map.put(S.charAt(i), new ArrayList<>());
            map.get(S.charAt(i)).add(i);
        }
        
        int count = 0;
        
        for(int i = 0; i < words.length; i++){
            
            String curr = words[i];
            System.out.println(curr);
            int prev = -1;
            int flag = 0;
            
            for(int j = 0; j < curr.length(); j++){
                char c = curr.charAt(j);
                if(map.get(c) == null){
                    flag = 1;
                    break;
                }
                prev = search(prev, map.get(c), 0, map.get(c).size() - 1);
                if(prev == -1){
                    flag = 1;
                    break;
                }
            }
            
            if(flag == 0) count++;
        }
        
        return count;
    }
}
