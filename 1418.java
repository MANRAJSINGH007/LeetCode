class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        int n = orders.size();
        HashSet<String> foodItems = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, HashMap<String, Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String food = orders.get(i).get(2);
            foodItems.add(food);
            int index = Integer.parseInt(orders.get(i).get(1));
            set.add(index);
            if(!map.containsKey(index)) map.put(index, new HashMap<>());
            HashMap<String, Integer> temp = map.get(index);
            if(!temp.containsKey(food)) temp.put(food, 1);
            else {
                int count = temp.get(food);
                count++;
                temp.put(food, count);
            }
        }
        List<String> foodItemsList = new ArrayList<>(foodItems);
        List<Integer> people = new ArrayList<>(set);
        Collections.sort(foodItemsList);
        Collections.sort(people);
        List<List<String>> ans = new ArrayList<>();
        List<String> headers = new ArrayList<>();
        headers.add("Table");
        for(int i = 0; i < foodItemsList.size(); i++) headers.add(foodItemsList.get(i));
        ans.add(headers);
        for(int j = 0; j < people.size(); j++) {
            List<String> x = new ArrayList<>();
            int p = people.get(j);
            x.add(Integer.toString(p));
            for(int t= 0; t < foodItemsList.size(); t++) {
                HashMap<String, Integer> temp = map.get(p);
                if(!temp.containsKey(foodItemsList.get(t))) x.add("0");
                else x.add(Integer.toString(temp.get(foodItemsList.get(t))));
            }
            ans.add(x);
        }
        return ans;
    }
}
