// Last updated: 6/13/2026, 11:38:24 PM
1class Solution {
2    public String mapWordWeights(String[] words, int[] weights) {
3        StringBuilder ans = new StringBuilder();
4        for(String word : words){
5            int sum = 0;
6            for(int i=0; i<word.length(); i++){
7                char ch = word.charAt(i);
8                int index = ch - 'a';
9                sum += weights[index];
10            }
11            int value = sum % 26;
12            char mapped = (char)('z' - value);
13            ans.append(mapped);
14        }
15        return ans.toString();
16    }
17}