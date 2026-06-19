// Last updated: 6/19/2026, 11:07:19 PM
1class Solution {
2    public int largestAltitude(int[] gain) {
3        int currentAltitude = 0;
4        int highestAltitude = 0;
5        for(int altitudeGain : gain) {
6            currentAltitude += altitudeGain;
7            highestAltitude = Math.max(highestAltitude, currentAltitude);
8        }
9        return highestAltitude;
10    }
11}