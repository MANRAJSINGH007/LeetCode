class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        
        int n = hand.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i = 0; i < n; i++){
            int count = 0;
            if(map.containsKey(hand[i])) count = map.get(hand[i]);
            count += 1;
            map.put(hand[i], count);
        }
        
        Set<Map.Entry<Integer, Integer>> keys = map.entrySet(); 
        for(Map.Entry<Integer, Integer> me : keys){
            int currVal = me.getKey();
            int prevFreq = me.getValue();
            // System.out.println(currVal + " " + prevFreq);
            if(prevFreq == 0) continue;
            map.put(currVal, 0);
            int count = 1;
            currVal ++;
            while(count < W){
                count++;
                if(!map.containsKey(currVal) || map.get(currVal) < prevFreq) return false;
                map.put(currVal, map.get(currVal) - prevFreq);
                currVal ++;
            }
        }
        
        return true;
    }
}
