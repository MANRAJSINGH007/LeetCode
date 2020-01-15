class Solution {
    public int nextGreaterElement(int n) {
        List<Integer> list = new ArrayList<>();
        while(n > 0) {
            list.add(0, n % 10);
            n /= 10;
        }
        n = list.size();
        int index = -1;
        for(int i = n - 2; i >= 0; i--) {
            if(list.get(i) < list.get(i + 1)) {
                index = i;
                break;
            }
        }
        if(index == -1) return index;
        int nextGreater = list.get(index + 1);
        int swapIndex = index + 1;
        for(int i = index + 2; i < n; i++) {
            if(list.get(i) > list.get(index) && list.get(i) <= nextGreater) {
                nextGreater = list.get(i);
                swapIndex = i;
            }
        }
        int temp = list.get(index);
        list.set(index, nextGreater);
        list.set(swapIndex, temp);
        for(int i = index + 1; i < (index + 1 + n)/2; i++) {
            int te = list.get(i);
            list.set(i, list.get(n - 1 + index + 1 - i));
            list.set(n - 1 + index + 1 - i, te);
        }
        long num = 0;
        for(int i = 0; i < n; i++) {
            num *= 10;
            num += (long)list.get(i);
        }
        return num > (long)Integer.MAX_VALUE ? -1 : (int)num;
    }
}
