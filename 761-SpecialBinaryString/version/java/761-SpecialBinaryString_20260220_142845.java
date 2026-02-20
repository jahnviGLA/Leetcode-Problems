// Last updated: 2/20/2026, 2:28:45 PM
1import java.util.*;
2class Solution {
3    public String makeLargestSpecial(String s) {
4        if (s.length() <= 2) return s;        
5        List<String> list = new ArrayList<>();
6        int count = 0;
7        int start = 0;        
8        for (int i = 0; i < s.length(); i++) {
9            if (s.charAt(i) == '1') count++;
10            else count--;
11            if (count == 0) {
12                String inner = makeLargestSpecial(s.substring(start + 1, i));
13                list.add("1" + inner + "0");
14                start = i + 1;
15            }
16        }
17        Collections.sort(list, Collections.reverseOrder());        
18        StringBuilder result = new StringBuilder();
19        for (String str : list) {
20            result.append(str);
21        }   
22        return result.toString();
23    }
24}
25