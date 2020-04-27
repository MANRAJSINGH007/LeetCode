class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length, y = nums2.length;
        if(x > y) return findMedianSortedArrays(nums2, nums1);
        int start = 0;
        int end = x;
        while(start <= end) {
            int px = (start + end) / 2;
            int py = (x + y + 1) / 2 - px;
            int x1 = px != 0 ? nums1[px - 1] : Integer.MIN_VALUE;
            int x2 = px != x ? nums1[px] : Integer.MAX_VALUE;
            int y1 = py != 0 ? nums2[py - 1] : Integer.MIN_VALUE;
            int y2 = py != y ? nums2[py] : Integer.MAX_VALUE;
            if(x1 <= y2 && y1 <= x2) return (x + y) % 2 == 0 ? (double)(Math.min(x2, y2) + Math.max(x1, y1)) / 2 : (double)Math.max(x1, y1);
            else if(x1 > y2) end = px - 1;
            else start = px + 1;
        } 
        return -1;
    }
}
