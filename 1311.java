class Pair {
    int index;
    int lev;
    Pair(int index, int lev) {
        this.index = index;
        this.lev = lev;
    }
}
class Pair2{
    String video;
    int freq;
    Pair2(String video, int freq) {
        this.video = video;
        this.freq = freq;
    }
}
class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> v, int[][] friends, int id, int level) {
        int n = v.size();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(id, 0));
        HashSet<Integer> visited = new HashSet<>();
        visited.add(id);
        HashMap<String, Integer> freq = new HashMap<>();
        
        while(q.size() > 0) {
            Pair obj = q.remove();
            if(obj.lev == level) {
                int f_index = obj.index;
                List<String> li = v.get(f_index);
                for(int k = 0; k < li.size(); k++) {
                    String video = li.get(k);
                    int count = 1;
                    if(freq.containsKey(video)) count += freq.get(video);
                    freq.put(video, count);
                }
            } else {
                int f_index = obj.index;
                int[] myFriends = friends[f_index];
                for(int k = 0; k < myFriends.length; k++) {
                    if(!visited.contains(myFriends[k])) {
                        visited.add(myFriends[k]);
                        q.add(new Pair(myFriends[k], obj.lev + 1));
                    }
                }
            }
        }
        
        List<Pair2> list = new ArrayList<>();
        List<String> ret = new ArrayList<>();
        Set<String> keys = freq.keySet();
        for(String s : keys) {
            list.add(new Pair2(s, freq.get(s)));
        }
        
        Collections.sort(list, new Comparator<Pair2>(){
            public int compare(Pair2 o1, Pair2 o2) {
                if(o1.freq != o2.freq) return o1.freq - o2.freq;
                for(int i = 0; i < Math.min(o1.video.length(), o2.video.length()); i++) {
                    if(o1.video.charAt(i) == o2.video.charAt(i)) continue;
                    return o1.video.charAt(i) - o2.video.charAt(i);
                }
                return o1.video.length() <= o2.video.length() ? - 1 : 1;
            }
        });
        for(int j = 0; j < list.size(); j++) ret.add(list.get(j).video);
        return ret;
    }
}
