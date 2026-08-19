// Last updated: 8/19/2026, 11:52:03 PM
1class Solution {
2    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
3        int left = 0b11110000;
4        int middle = 0b11000011;
5        int right = 0b00001111;
6        Map<Integer, Integer> occupied = new HashMap<Integer, Integer>();
7        for (int[] seat : reservedSeats) {
8            if (seat[1] >= 2 && seat[1] <= 9) {
9                int origin = occupied.containsKey(seat[0])
10                    ? occupied.get(seat[0])
11                    : 0;
12                int value = origin | (1 << (seat[1] - 2));
13                occupied.put(seat[0], value);
14            }
15        }
16
17        int ans = (n - occupied.size()) * 2;
18        for (Map.Entry<Integer, Integer> entry : occupied.entrySet()) {
19            int row = entry.getKey(),
20                bitmask = entry.getValue();
21            if (
22                (bitmask | left) == left ||
23                (bitmask | middle) == middle ||
24                (bitmask | right) == right
25            ) {
26                ++ans;
27            }
28        }
29        return ans;
30    }
31}