class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        outer : for(int i = 0; i < n; i++) {
            if(stack.size() == 0 || stack.peek() * asteroids[i] > 0 || stack.peek() < 0 && asteroids[i] > 0) stack.push(asteroids[i]);
            else {
                while(stack.size() > 0 && stack.peek() > 0 && stack.peek() <= -asteroids[i]) {
                    if(stack.pop() + asteroids[i] == 0) continue outer;
                }
                if(stack.size() == 0 || stack.peek() < 0) stack.push(asteroids[i]);
            }
        }
        int m = stack.size();
        int[] ans = new int[m];
        for(int i = m - 1; i >= 0; i--) ans[i] = stack.pop();
        return ans;
    }
}
