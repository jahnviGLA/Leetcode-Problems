// Last updated: 3/3/2026, 10:34:28 PM
1class Solution {
2    public int[] singleNumber(int[] nums) {
3        int xor = 0;
4        for (int num : nums) {
5            xor ^= num;
6        }
7        int diff = xor & (-xor);       
8        int num1 = 0;
9        int num2 = 0;
10        for (int num : nums) {
11            if ((num & diff) == 0) {
12                num1 ^= num;
13            } else {
14                num2 ^= num;
15            }
16        }        
17        return new int[]{num1, num2};
18    }
19}