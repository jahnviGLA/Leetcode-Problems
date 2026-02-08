// Last updated: 2/8/2026, 10:54:34 PM
1class Solution {
2    public int[] topKFrequent(int[] nums, int k) {
3        Map<Integer, Integer> freqMap = new HashMap<>();
4        for (int num : nums) {
5            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
6        }
7        List<Integer>[] buckets = new List[nums.length + 1];
8        for (int key : freqMap.keySet()) {
9            int freq = freqMap.get(key);
10            if (buckets[freq] == null) {
11                buckets[freq] = new ArrayList<>();
12            }
13            buckets[freq].add(key);
14        }
15        int[] result = new int[k];
16        int index = 0;
17        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
18            if (buckets[i] != null) {
19                for (int num : buckets[i]) {
20                    result[index++] = num;
21                    if (index == k) break;
22                }
23            }
24        }
25        return result;
26    }
27}
28