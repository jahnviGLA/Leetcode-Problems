// Last updated: 2/21/2026, 10:07:13 PM
1class Solution {
2    public int countPrimeSetBits(int left, int right) {
3        int count = 0;        
4        for (int i = left; i <= right; i++) {
5            int bits = Integer.bitCount(i);
6            if (isPrime(bits)) {
7                count++;
8            }
9        }        
10        return count;
11    }    
12    private boolean isPrime(int n) {
13        if (n < 2) return false;        
14        for (int i = 2; i * i <= n; i++) {
15            if (n % i == 0) return false;
16        }        
17        return true;
18    }
19}