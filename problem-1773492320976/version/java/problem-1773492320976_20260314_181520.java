// Last updated: 3/14/2026, 6:15:20 PM
1class Solution {
2
3    int count = 0;
4    String ans = "";
5
6    public String getHappyString(int n, int k) {
7        dfs(n, k, new StringBuilder());
8        return ans;
9    }
10
11    private void dfs(int n, int k, StringBuilder sb){
12
13        if(sb.length() == n){
14            count++;
15
16            if(count == k){
17                ans = sb.toString();
18            }
19
20            return;
21        }
22
23        char[] chars = {'a','b','c'};
24
25        for(char c : chars){
26
27            if(sb.length() > 0 && sb.charAt(sb.length()-1) == c)
28                continue;
29
30            sb.append(c);
31
32            dfs(n, k, sb);
33
34            if(ans.length() != 0) 
35                return;
36
37            sb.deleteCharAt(sb.length()-1);
38        }
39    }
40}