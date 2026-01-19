// Last updated: 1/19/2026, 1:15:12 PM
class Solution {
    public int fib(int n) {
        if(n<=1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
}