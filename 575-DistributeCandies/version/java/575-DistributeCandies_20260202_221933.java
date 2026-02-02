// Last updated: 2/2/2026, 10:19:33 PM
1import java.util.*;
2class Solution {
3    public int distributeCandies(int[] candyType) {
4        Set<Integer> set = new HashSet<>();
5        for (int candy : candyType) {
6            set.add(candy);
7        }
8        return Math.min(set.size(), candyType.length / 2);
9    }
10}
11