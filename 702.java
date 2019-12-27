class Solution {
    public int search(ArrayReader reader, int target) {
        int start = 0, end = Integer.MAX_VALUE;
        while(start <= end){
            int mid = (start) + (end - start)/2;
            int element = reader.get(mid);
            if(element > target) end = mid - 1;
            else if(element == target) return mid;
            else start = mid + 1;
        }
        return -1;
    }
}
