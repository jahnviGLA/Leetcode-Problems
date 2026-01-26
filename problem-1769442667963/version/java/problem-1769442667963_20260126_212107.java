// Last updated: 1/26/2026, 9:21:07 PM
1class Solution {
2    public List<List<Integer>> minimumAbsDifference(int[] arr) {
3        Arrays.sort(arr);
4        
5        int minDiff = Integer.MAX_VALUE;
6        List<List<Integer>> result = new ArrayList<>();
7        for (int i = 1; i < arr.length; i++) {
8            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
9        }
10        for (int i = 1; i < arr.length; i++) {
11            if (arr[i] - arr[i - 1] == minDiff) {
12                result.add(Arrays.asList(arr[i - 1], arr[i]));
13            }
14        }       
15        return result;
16    }
17}
18