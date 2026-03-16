// Last updated: 3/16/2026, 10:01:48 AM
1class Solution {
2    public int countPrimes(int n) {
3
4        if (n <= 2) return 0;
5
6        boolean[] isPrime = new boolean[n];
7
8        for (int i = 2; i < n; i++) {
9            isPrime[i] = true;
10        }
11
12        for (int i = 2; i * i < n; i++) {
13            if (isPrime[i]) {
14                for (int j = i * i; j < n; j += i) {
15                    isPrime[j] = false;
16                }
17            }
18        }
19
20        int count = 0;
21
22        for (int i = 2; i < n; i++) {
23            if (isPrime[i]) count++;
24        }
25
26        return count;
27    }
28}