class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        
        int n = regions.size();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            List<String> curr = regions.get(i);
            for(int j = curr.size() - 1; j >= 1; j--) map.put(curr.get(j), i);
        }
        
        List<String> list1 = new ArrayList<>();
        while(map.containsKey(region1)){
            int index = map.get(region1);
            list1.add(region1);
            region1 = regions.get(index).get(0);
        }
        
        list1.add(region1);
        
        List<String> list2 = new ArrayList<>();
        while(map.containsKey(region2)){
            int index = map.get(region2);
            list2.add(region2);
            region2 = regions.get(index).get(0);
        }
        
        list2.add(region2);
        
        String ans = "";
        int i1 = list1.size() - 1;
        int i2 = list2.size() - 1;
        
        while(i1 >=0 && i2 >= 0){
            if(list1.get(i1).equals(list2.get(i2))) ans = list1.get(i1);
            else break;
            i1--;
            i2--;
        }
        
        return ans;
               
        
    }
}
