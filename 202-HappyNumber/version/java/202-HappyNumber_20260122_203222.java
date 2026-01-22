// Last updated: 1/22/2026, 8:32:22 PM
1class Solution {
2    public boolean isHappy(int n) {
3        int slow = n;
4        int fast = n;
5        do {
6            slow = getNext(slow);          
7            fast = getNext(getNext(fast)); 
8        } while (slow != fast);
9        return slow == 1;
10    }
11    private int getNext(int n) {
12        int sum = 0;
13        while (n > 0) {
14            int digit = n % 10;
15            sum += digit * digit;
16            n /= 10;
17        }
18        return sum;
19    }
20}
21