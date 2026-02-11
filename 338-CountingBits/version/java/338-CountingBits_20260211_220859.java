// Last updated: 2/11/2026, 10:08:59 PM
1class Solution {
2    public int[] countBits(int n){
3        int[] ans=new int[n+1];
4        for (int i=1;i<=n;i++) {
5            ans[i]=ans[i>>1]+(i&1);
6        }
7        return ans;
8    }
9}
10