class Solution {
    public boolean confusingNumber(int n) {
        List<Integer> list = new ArrayList<>();
        int num = n;
        while(n > 0){
            int digit = n % 10;
            if(digit >= 2 && digit <= 5 || digit == 7) return false;
            if(digit == 6 || digit == 9){
                if(digit == 6) list.add(9);
                else list.add(6);
            } else{
                list.add(digit);
            }
            n /= 10;
        }
        int x = 0;
        for(int i = 0; i < list.size(); i++){
            x *= 10;
            x += list.get(i);
        }
        return x != num;
    }
}
