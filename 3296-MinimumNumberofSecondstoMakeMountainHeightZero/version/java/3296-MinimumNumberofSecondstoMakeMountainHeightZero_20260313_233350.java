// Last updated: 3/13/2026, 11:33:50 PM
1class Solution {
2
3    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
4        
5        long left = 1;
6        long right = (long)1e18;
7        long ans = right;
8
9        while(left <= right){
10            long mid = left + (right - left) / 2;
11
12            if(can(mid, mountainHeight, workerTimes)){
13                ans = mid;
14                right = mid - 1;
15            } else {
16                left = mid + 1;
17            }
18        }
19
20        return ans;
21    }
22
23    private boolean can(long time, int height, int[] workerTimes){
24
25        long total = 0;
26
27        for(int w : workerTimes){
28
29            long limit = (2 * time) / w;
30
31            long l = 0, r = 100000;
32
33            while(l <= r){
34                long mid = (l + r) / 2;
35
36                if(mid * (mid + 1) <= limit){
37                    l = mid + 1;
38                } else {
39                    r = mid - 1;
40                }
41            }
42
43            total += r;
44
45            if(total >= height)
46                return true;
47        }
48
49        return total >= height;
50    }
51}