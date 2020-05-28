class Solution {
    public String arrangeWords(String text) {
        String[] aux = text.split(" ");
        List<String[]> list = new ArrayList<>();
        for(int i = 0; i < aux.length; i++) list.add(new String[] {aux[i], Integer.toString(i)});
        Collections.sort(list, new Comparator<String[]>(){
            public int compare(String[] a1, String[] a2) {
                if(a1[0].length() < a2[0].length()) return -1;
                if(a1[0].length() > a2[0].length()) return 1;
                if(Integer.parseInt(a1[1]) < Integer.parseInt(a2[1])) return -1;
                return 1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            String curr = list.get(i)[0];
            if(i == 0) {
                char[] t = curr.toCharArray();
                if(t[0] - 'a' >= 0) t[0] = (char)((int)t[0] - 32);
                sb.append(new String(t));
            } else sb.append(curr.toLowerCase());
            if(i != list.size() - 1) sb.append(" ");
        }
        return sb.toString();
    }
}
