// Last updated: 2/25/2026, 11:32:02 PM
1import java.util.*;
2
3class Solution {
4    public int[] sortByBits(int[] arr) {        
5        Integer[] nums = new Integer[arr.length];
6        for(int i = 0; i < arr.length; i++) {
7            nums[i] = arr[i];
8        }        
9        Arrays.sort(nums, (a, b) -> {
10            int countA = Integer.bitCount(a);
11            int countB = Integer.bitCount(b);            
12            if(countA == countB) {
13                return a - b;   
14            }            
15            return countA - countB;  
16        });
17        for(int i = 0; i < arr.length; i++) {
18            arr[i] = nums[i];
19        }        
20        return arr;
21    }
22}