class Pair implements Comparable<Pair>{
    
    int value;
    int label;
    Pair(int value, int label){
        this.value = value;
        this.label = label;
    }
    
    public int compareTo(Pair obj){
        return obj.value - this.value;
    }
    
}
class Solution {
    
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        
        int n = values.length;
        
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Pair(values[i], labels[i]);
        }
        
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int count = 0;
        
        for(int i = 0; i < n; i++){
            int curr_label = arr[i].label;
            if(map.containsKey(curr_label) && map.get(curr_label) == use_limit) continue;
            
            if(!map.containsKey(curr_label)){
                ans += arr[i].value;
                map.put(curr_label, 1);
            }
            
            else{
                int currCount = map.get(curr_label);
                currCount++;
                map.put(curr_label, currCount);
                ans += arr[i].value;
            }
            
            if(++ count == num_wanted) return ans;
        }
        
        return ans;
        
    }
}
