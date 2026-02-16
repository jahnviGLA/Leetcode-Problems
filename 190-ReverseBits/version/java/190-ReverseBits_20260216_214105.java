// Last updated: 2/16/2026, 9:41:05 PM
1class Solution
2{
3    public int reverseBits(int n) {
4    int result = 0;
5    for (int i = 0; i < 32; i++) {
6        result <<= 1;        
7        result |= (n & 1);   
8        n >>= 1;             
9    }
10    return result;
11    }
12}
13