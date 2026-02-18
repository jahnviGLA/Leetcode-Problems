// Last updated: 2/18/2026, 12:03:18 PM
1class Solution{
2    public List<Integer> grayCode(int n) {
3        List<Integer> result = new ArrayList<>();
4        int size=1<<n;  
5        for (int i=0;i<size;i++) {
6            result.add(i^(i>>1));
7        }
8        return result;
9    }
10}
11