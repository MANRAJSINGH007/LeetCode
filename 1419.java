class Solution {
    public static boolean check(HashMap<Character, Integer> map, char[] arr) {
        for(int i = 0; i < 5; i++) if(map.get(arr[i]) != 0) return true;
        return false;
    }
    public int minNumberOfFrogs(String croakOfFrogs) {
        int n = croakOfFrogs.length();
        char[] arr = {'c', 'r', 'o', 'a', 'k'};
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> index = new HashMap<>();
        for(int i = 0; i < 5; i++) {
            map.put(arr[i], 0);
            index.put(arr[i], i);
        }
        int count = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            char curr = croakOfFrogs.charAt(i);
            int j = index.get(curr);
            if(curr == 'c') {
                if(count == 0 || check(map, arr)) count++;
                max = Math.max(max, count);
                map.put('c', map.get('c') + 1);
            } else {
                if(map.get(curr) + 1 > map.get(arr[j - 1])) return -1;
                map.put(curr, map.get(curr) + 1);
                if(curr == 'k') {
                    for(int g = 0; g < 5; g++) {
                        map.put(arr[g], map.get(arr[g]) - 1);
                    }
                    count--;
                }
            }
        }
        for(int i = 0; i < 5; i++) if(map.get(arr[i]) != 0) return -1;
        return max;
    }
}
