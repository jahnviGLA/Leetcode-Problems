// Last updated: 1/19/2026, 11:40:05 PM
1import java.util.*;
2class Solution {
3    public List<Integer> getRow(int rowIndex) {
4        List<Integer> row = new ArrayList<>();
5        row.add(1);
6        for (int i = 1; i <= rowIndex; i++) {
7            for (int j = row.size() - 1; j >= 1; j--) {
8                row.set(j, row.get(j) + row.get(j - 1));
9            }
10            row.add(1);
11        }
12        return row;
13    }
14}
15