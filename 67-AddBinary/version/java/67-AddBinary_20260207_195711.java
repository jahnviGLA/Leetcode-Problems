// Last updated: 2/7/2026, 7:57:11 PM
1class Solution {
2    public String addBinary(String a, String b) {
3        int i=a.length()-1;
4        int j=b.length()-1;
5        int carry=0;
6        StringBuilder sb=new StringBuilder();
7        while (i>=0||j>=0||carry==1) {
8            int sum=carry;
9            if (i>=0) {
10                sum+=a.charAt(i--)-'0';
11            }
12            if (j>=0) {
13                sum+=b.charAt(j--)-'0';
14            }
15            sb.append(sum%2);
16            carry=sum/2;
17        }
18        return sb.reverse().toString();
19    }
20}
21