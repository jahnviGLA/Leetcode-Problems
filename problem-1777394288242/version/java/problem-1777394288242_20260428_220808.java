// Last updated: 4/28/2026, 10:08:08 PM
1import java.util.*;
2class Solution {
3    public int minOperations(int[][] grid, int x) {
4        List<Integer> nums = new ArrayList<>();       
5        int rem = grid[0][0] % x;
6        for(int[] row : grid){
7            for(int num : row){
8                if(num % x != rem){
9                    return -1;
10                }
11                nums.add(num);
12            }
13        }
14        Collections.sort(nums);
15        int median = nums.get(nums.size()/2);
16        int operations = 0;
17        for(int num : nums){
18            operations += Math.abs(num - median) / x;
19        }
20        
21        return operations;
22    }
23}