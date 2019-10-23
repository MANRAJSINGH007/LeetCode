class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        
        String[] arr = text.split(" ");
        int n = arr.length;
        
        List<String> ans = new ArrayList<>();
        
        for(int i = 0; i < n - 2; i++){
            if(arr[i].equals(first) && arr[i + 1].equals(second)) ans.add(arr[i + 2]);
        }
        
        String[] ret = new String[ans.size()];
        
        for(int i = 0; i < ret.length; i++){
            ret[i] = ans.get(i);
        }
        
        return ret;
        
    }
}
