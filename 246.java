class Solution {
    public boolean isStrobogrammatic(String str) {
        List<Integer> list = new ArrayList<>();
        int i = str.length() - 1;
        while(i >= 0){
            int digit = str.charAt(i) - '0';
            if(digit >= 2 && digit <= 5 || digit == 7) return false;
            if(digit == 6 || digit == 9){
                if(digit == 6) list.add(9);
                else list.add(6);
            } else{
                list.add(digit);
            }
            i--;
        }
        String x = "";
        for(i = 0; i < list.size(); i++){
            x += Integer.toString(list.get(i));
        }
        return x.equals(str);
    }
}
