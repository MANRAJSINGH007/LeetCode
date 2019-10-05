class Pair{
    
    int data;
    int freq;
    
    Pair(int data, int freq){
        this.data = data;
        this.freq = freq;
    }
}

class Compare implements Comparator<Pair>{
    
  public int compare(Pair p1, Pair p2){
      if(p1.freq < p2.freq) return -1;
      if(p1.freq > p2.freq) return 1;
      return 0;
  }
}

class Solution {
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        int n = nums.length;
        
        List<Integer> list = new ArrayList<>();
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < n; i++){
            
            int count = 0;
            
            if(map.containsKey(nums[i])){
                count = map.get(nums[i]);
            }
            
            count++;
            map.put(nums[i], count);
        }
        
        Set<Integer> keys = map.keySet();
        
        Compare object = new Compare();
      
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(object);
        
        List<Integer> unique = new ArrayList<>();
        for(Integer key : keys){
            unique.add(key);
        }
        
        for(int i = 0; i < k; i++){
            pq.add(new Pair(unique.get(i), map.get(unique.get(i))));
        }
        
        
        for(int i = k; i < unique.size(); i++){
            int curr = unique.get(i);
            int freq = map.get(curr);
            if(freq > pq.peek().freq){
                pq.remove();
                pq.add(new Pair(curr, freq));
            }
            else if(freq == pq.peek().freq && curr > pq.peek().data){
                pq.remove();
                pq.add(new Pair(curr, freq));
            }
        }
        
        while(pq.size() > 0){
            list.add(pq.remove().data);
        }
        
        return list;
        
    }
}
