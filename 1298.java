class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int ans = 0;
        int n = candies.length;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> boxKey = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> seen = new HashSet<>();
        for(int i = 0; i < initialBoxes.length; i++){
            boxKey.add(initialBoxes[i]);
            q.add(initialBoxes[i]);
            visited.add(initialBoxes[i]);
        }
        
        while(q.size() > 0){
            int b = q.remove();
            if(status[b] == 0 && !boxKey.contains(b)) continue;
            ans += candies[b];
            for(int i = 0; i < keys[b].length; i++) boxKey.add(keys[b][i]);
            Iterator<Integer> it = seen.iterator();
            while(it.hasNext()){
                int boxx = it.next();
                if(!visited.contains(boxx)){
                    visited.add(boxx);
                    q.add(boxx);
                }
            }
            for(int i = 0; i < containedBoxes[b].length; i++){
                if(status[containedBoxes[b][i]] == 1) boxKey.add(containedBoxes[b][i]);
                if(!boxKey.contains(containedBoxes[b][i])){
                    seen.add(containedBoxes[b][i]);
                    continue;
                }
                visited.add(containedBoxes[b][i]);
                q.add(containedBoxes[b][i]);
            }
        }
        
        return ans;
    }
}
