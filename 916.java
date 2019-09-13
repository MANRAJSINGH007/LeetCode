class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        
        int arr[] = new int[26];
        
        for(int i = 0; i < B.length; i++){
            String curr = B[i];
            int[] aux = new int[26];
            for(int j = 0; j < curr.length(); j++){
                aux[(int)curr.charAt(j) - 97]++;
            }
            
            for(int j = 0; j < 26; j++){
                arr[j] = Math.max(arr[j], aux[j]);
            }
        }
        
        List<String> ans = new ArrayList<>();
        
        for(int i = 0; i < A.length; i++){
            String curr = A[i];
            int[] temp = new int[26];
            for(int k = 0; k < curr.length(); k++){
                temp[(int)curr.charAt(k) - 97]++;
            }
            int flag = 0;
            for(int k = 0; k < 26; k++){
                if(temp[k] < arr[k]){
                    flag = 1;
                    break;
                }
            }
            
            if(flag == 0) ans.add(curr);
        }
        
        return ans;
        
    }
}
