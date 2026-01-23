// Last updated: 1/23/2026, 10:58:08 PM
1class Solution {
2    int count = 0;
3    public int countArrangement(int n) {
4        boolean[] used = new boolean[n + 1];
5        backtrack(1, n, used);
6        return count;
7    }
8    private void backtrack(int pos, int n, boolean[] used) {
9        if (pos > n) {
10            count++;
11            return;
12        }
13        for (int num = 1; num <= n; num++) {
14            if (!used[num] && (num % pos == 0 || pos % num == 0)) {
15                used[num] = true;
16                backtrack(pos + 1, n, used);
17                used[num] = false; 
18            }
19        }
20    }
21}
22