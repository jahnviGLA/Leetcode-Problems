// Last updated: 1/28/2026, 10:56:28 PM
1import java.util.*;
2
3class Solution {
4    public String[] findRelativeRanks(int[] score) {
5        int n = score.length;
6        String[] answer = new String[n];
7        int[][] arr = new int[n][2];
8        for (int i = 0; i < n; i++) {
9            arr[i][0] = score[i];
10            arr[i][1] = i;
11        }
12        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
13        for (int i = 0; i < n; i++) {
14            int idx = arr[i][1];
15            if (i == 0) {
16                answer[idx] = "Gold Medal";
17            } else if (i == 1) {
18                answer[idx] = "Silver Medal";
19            } else if (i == 2) {
20                answer[idx] = "Bronze Medal";
21            } else {
22                answer[idx] = String.valueOf(i + 1);
23            }
24        }
25        return answer;
26    }
27}
28