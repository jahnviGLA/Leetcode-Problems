// Last updated: 5/11/2026, 11:55:45 PM
1class Solution {
2    public int[] separateDigits(int[] nums) {
3        ArrayList<Integer> list = new ArrayList<>();
4        for (int num : nums) {
5            String s = String.valueOf(num);
6            for (char ch : s.toCharArray()) {
7                list.add(ch - '0');
8            }
9        }
10        int[] answer = new int[list.size()];
11        for (int i = 0; i < list.size(); i++) {
12            answer[i] = list.get(i);
13        }
14        return answer;
15    }
16}