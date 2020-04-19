class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int i = 0, j = 0;
        HashSet<Integer> set = new HashSet<>();
        while((int)Math.pow(x, i) <= bound) {
            j = 0;
            while((int)Math.pow(x, i) + (int)Math.pow(y, j) <= bound) {
                set.add((int)Math.pow(x, i) + (int)Math.pow(y, j));
                j++;
                if(y == 1) break;
            }
            i++;
            if(x == 1) break;
        }
        return new ArrayList<>(set);
    }
}
