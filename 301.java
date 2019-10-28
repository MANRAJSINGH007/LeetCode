class Solution {
    
    public static int func(String s, int n, int i, int opening, int closing){
        
        if(i == n) return opening == closing ? 0 : Integer.MIN_VALUE;
        
        char curr = s.charAt(i);
        
        if(curr != '(' && curr != ')') return 1 + func(s, n, i + 1, opening, closing);
        
        if(curr == '('){
            return Math.max(1 + func(s, n, i + 1, opening + 1, closing), func(s, n, i + 1, opening, closing));
        }
        
        if(opening == closing) return func(s, n, i + 1, opening, closing);
        
        return Math.max(1 + func(s, n, i + 1, opening, closing + 1), func(s, n, i + 1, opening, closing));
        
    }
    
    public static List<String> func(String s, int n, int i, int opening, int closing, int len){
        
        if(len == 0){
            if(opening == closing) return new ArrayList<>();
            return null;
        }
        
        if(i == n) return null;
        
        char curr = s.charAt(i);
        
        if(curr != '(' && curr != ')'){
            List<String> temp = func(s, n, i + 1, opening, closing, len - 1);
            List<String> t = new ArrayList<>();
            
            if(temp == null) return null;
            
            if(temp.size() == 0){
                t.add("" + curr);
                return t;
            }
            
            for(int j = 0; j < temp.size(); j++){
                String str = temp.get(j);
                t.add("" + curr + str);
            }
            
            return t;
        }
        
        if(curr == '('){
            
            List<String> t1 = func(s, n, i + 1, opening + 1, closing, len - 1);
            List<String> t2 = func(s, n, i + 1, opening, closing, len);
            List<String> t = new ArrayList<>();
            if(t1 == null && t2 == null) return null;
            
            if(t1 != null){
                for(int j = 0; j < t1.size(); j++){
                    String str = t1.get(j);
                    t.add("" + '(' + str);
                }
                
                if(t1.size() == 0) t.add("(");
                
            }
            
            if(t2 != null){
                for(int j = 0; j < t2.size(); j++){
                    t.add(t2.get(j));
                }
            }
            
            return t;   
        }
        
        if(opening == closing){
            List<String> t2 = func(s, n, i + 1, opening, closing, len);
            List<String> t = new ArrayList<>();
            if(t2 == null) return null;

            if(t2 != null){
                for(int j = 0; j < t2.size(); j++){
                    t.add(t2.get(j));
                }
            }

            return t;
        }
        
        List<String> t1 = func(s, n, i + 1, opening, closing + 1, len - 1);
        List<String> t2 = func(s, n, i + 1, opening, closing, len);
        List<String> t = new ArrayList<>();
        if(t1 == null && t2 == null) return null;

        if(t1 != null){
            for(int j = 0; j < t1.size(); j++){
                String str = t1.get(j);
                t.add("" + ')' + str);
            }
            
            if(t1.size() == 0) t.add(")");
        }
        
        if(t2 != null){
            for(int j = 0; j < t2.size(); j++){
                t.add(t2.get(j));
            }
        }

        return t;
        
    }
    
    public List<String> removeInvalidParentheses(String s) {
        
        int n = s.length();
        int max = func(s, n, 0, 0, 0);
        if(max == 0){
            List<String> t = new ArrayList<>();
            t.add("");
            return t;
        }
        // System.out.println(max);
        List<String> ans = func(s, n, 0, 0, 0, max);
        if(ans == null) ans = new ArrayList<>();
        if(ans.size() == 0){
            String str = "";
            for(int i = 0; i < n; i++){
                if(s.charAt(i) != ')' && s.charAt(i) != '(') str += s.charAt(i);
            }
            ans.add(str);
            return ans;
        }
        
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < ans.size(); i++){
            set.add(ans.get(i));
        }
        
        ans = new ArrayList<>();
        Iterator value = set.iterator(); 
        while(value.hasNext()) ans.add(value.next().toString());
        return ans;
    }
}
