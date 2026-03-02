// Last updated: 3/2/2026, 9:38:03 PM
1class Solution {
2    public int minSwaps(int[][] grid) {
3        int n = grid.length;
4        int[] trailing = new int[n];
5        for (int i = 0; i < n; i++) {
6            int count = 0;
7            for (int j = n - 1; j >= 0; j--) {
8                if (grid[i][j] == 0) count++;
9                else break;
10            }
11            trailing[i] = count;
12        }        
13        int swaps = 0;
14        for (int i = 0; i < n; i++) {
15            int required = n - 1 - i;
16            int j = i;
17            while (j < n && trailing[j] < required) {
18                j++;
19            }
20            
21            if (j == n) return -1;  
22            while (j > i) {
23                int temp = trailing[j];
24                trailing[j] = trailing[j - 1];
25                trailing[j - 1] = temp;
26                j--;
27                swaps++;
28            }
29        }       
30        return swaps;
31    }
32}