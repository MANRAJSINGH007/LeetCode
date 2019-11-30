/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    
    public static int f(Sea sea, int x1, int y1, int x2, int y2) {
        if(x2 < x1 || y2 < y1) return 0;
        
        int[] to = new int[2];
        int[] bo = new int[2];
        
        to[0] = x2;
        to[1] = y2;
        bo[0] = x1;
        bo[1] = y1;
        
        if(!sea.hasShips(to, bo)) return 0;
        
        if(x2 == x1 && y2 == y1 && sea.hasShips(to, bo)) return 1;
        
        int a = (x2 - x1) / 2, b = (y2 - y1) / 2;
        return f(sea, x1, y1, x1 + a, y1 + b) + f(sea, x1 + a + 1, y1 + b + 1, x2, y2)
            + f(sea, x1 + a + 1, y1, x2, y1 + b) + f(sea, x1, y1 + b + 1, x1 + a, y2);
    }
    
    
    public int countShips(Sea sea, int[] t, int[] b) {
        
        int x1 = b[0], y1 = b[1], x2 = t[0], y2 = t[1];
        return f(sea, x1, y1, x2, y2);
        
    }
}
