class WordDistance {
    HashMap<String, ArrayList<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            if(!map.containsKey(words[i])) map.put(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        ArrayList<Integer> l1 = map.get(word1);
        ArrayList<Integer> l2 = map.get(word2);
        int i1 = 0, i2 = 0;
        int min = Integer.MAX_VALUE;
        while(i1 < l1.size() && i2 < l2.size()){
            min = Math.min(min, Math.abs(l1.get(i1) - l2.get(i2)));
            if(l1.get(i1) <= l2.get(i2)) i1++;
            else i2++;
        }
        return min;
    }
}
