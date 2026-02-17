// Last updated: 2/17/2026, 10:42:08 PM
1import java.util.*;
2class Solution {
3    public List<String> readBinaryWatch(int turnedOn) {
4        List<String> result = new ArrayList<>();
5        for (int hour = 0; hour < 12; hour++) {
6            for (int minute = 0; minute < 60; minute++) {                
7                int totalBits = Integer.bitCount(hour) + Integer.bitCount(minute);               
8                if (totalBits == turnedOn) {
9                    String time = hour + ":" + (minute < 10 ? "0" + minute : minute);
10                    result.add(time);
11                }
12            }
13        }
14        return result;
15    }
16}
17