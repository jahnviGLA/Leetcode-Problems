// Last updated: 3/29/2026, 11:07:10 PM
1class Solution {
2    public boolean canBeEqual(String s1, String s2) {
3        char[] s1Even = new char[]{s1.charAt(0), s1.charAt(2)};
4        char[] s1Odd = new char[]{s1.charAt(1), s1.charAt(3)};
5        
6        char[] s2Even = new char[]{s2.charAt(0), s2.charAt(2)};
7        char[] s2Odd = new char[]{s2.charAt(1), s2.charAt(3)};
8        
9        Arrays.sort(s1Even);
10        Arrays.sort(s1Odd);
11        Arrays.sort(s2Even);
12        Arrays.sort(s2Odd);
13        
14        return Arrays.equals(s1Even, s2Even) && Arrays.equals(s1Odd, s2Odd);
15    }
16}