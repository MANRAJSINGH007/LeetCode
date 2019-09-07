class Pair{
    int one = Integer.MAX_VALUE;
    int two = Integer.MAX_VALUE;
    int three = Integer.MAX_VALUE;
    
    Pair(int one, int two, int three){
        this.one = one;
        this.two = two;
        this.three = three;
    }
}

class Solution {
    
    public static void preprocess(int[] colors, int n, Pair[] left, Pair[] right){
        
        if(colors[0] == 1){
            left[0].one = 0;
        }
        else if(colors[0] == 2){
            left[0].two = 0;
        }
        else{
            left[0].three = 0;
        }
        
        for(int i = 1; i < n; i++){
            left[i].one = left[i - 1].one;
            left[i].two = left[i - 1].two;
            left[i].three = left[i - 1].three;
            if(colors[i] == 1){
                left[i].one = i;
            }
            else if(colors[i] == 2){
                left[i].two = i;
            }
            else{
                left[i].three = i;
            }
        }
        
        if(colors[n - 1] == 1){
            right[n - 1].one = n - 1;
        }
        else if(colors[n - 1] == 2){
            right[n - 1].two = n - 1;
        }
        else{
            right[n - 1].three = n - 1;
        }
        
        for(int i = n - 2; i > -1; i--){
            right[i].one = right[i + 1].one;
            right[i].two = right[i + 1].two;
            right[i].three = right[i + 1].three;
            if(colors[i] == 1){
                right[i].one = i;
            }
            else if(colors[i] == 2){
                right[i].two = i;
            }
            else{
                right[i].three = i;
            }
        }
        
        return ;
        
    }
    
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        
        int n = colors.length;
        Pair[] left = new Pair[n];
        Pair[] right = new Pair[n];
        
        for(int i = 0; i < n; i++){
            left[i] = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
            right[i] = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        
        List<Integer> list = new ArrayList<>();
        
        preprocess(colors, n, left, right);
        
        for(int i = 0; i < queries.length; i++){
            int index = queries[i][0];
            int color = queries[i][1];
            
            if(color == 1){
                int x1 = left[index].one;
                int x2 = right[index].one;
                int min = n;
                if(x1 != Integer.MAX_VALUE){
                    min = index - x1;
                }
                if(x2 != Integer.MAX_VALUE){
                    min = Math.min(min, x2 - index);
                }
                if(min == n){
                    min = -1;
                }
                list.add(min);
            }
            else if(color == 2){
                int x1 = left[index].two;
                int x2 = right[index].two;
                int min = n;
                if(x1 != Integer.MAX_VALUE){
                    min = index - x1;
                }
                if(x2 != Integer.MAX_VALUE){
                    min = Math.min(min, x2 - index);
                }
                if(min == n){
                    min = -1;
                }
                list.add(min);
            }
            else{
                int x1 = left[index].three;
                int x2 = right[index].three;
                int min = n;
                if(x1 != Integer.MAX_VALUE){
                    min = index - x1;
                }
                if(x2 != Integer.MAX_VALUE){
                    min = Math.min(min, x2 - index);
                }
                if(min == n){
                    min = -1;
                }
                list.add(min);
            }
        }
        
        return list;
        
    }
}
