class Solution {
    public int totalFruit(int[] tree) {
        
        int n=tree.length;
        
        if(n==0){
            return 0;
        }
        
        int first_tree=-1;
        int second_tree=-1;
        
        int s1=-1;
        int e1=-1;
        int s2=-1;
        int e2=-1;
        int f1=0;
        int f2=0;
        int max=0;
        
        int i=0;
        
        while(i<n){
            
            if(s1==-1){
                first_tree=tree[i];
                s1=i;
                e1=i;
                f1=1;
                max=1;
            }
            
            else if(tree[i]==first_tree){
                e1=i;
                f1++;
                max=Math.max(f1+f2,max);
            }
            
            else if(s2==-1){
                second_tree=tree[i];
                s2=i;
                e2=i;
                f2=1;
                max=Math.max(f1+f2,max);
            }
            
            else if(tree[i]==second_tree){
                e2=i;
                f2++;
                max=Math.max(f1+f2,max);
            }
            
            else{
                if(e1>e2){
                    s1=e2+1;
                    e1=i-1;
                    f1=e1-e2;
                    f2=1;
                    second_tree=tree[i];
                    s2=i;
                    e2=i;
                    max=Math.max(f1+f2,max);
                }
                else{
                    s1=e1+1;
                    e1=i-1;
                    f1=e1-s1+1;
                    first_tree=second_tree;
                    second_tree=tree[i];
                    s2=i;
                    e2=i;
                    f2=1;
                    max=Math.max(f1+f2,max);
                }
            }
            
            
            i++;
        }
        
        return max;
        
    }
}
