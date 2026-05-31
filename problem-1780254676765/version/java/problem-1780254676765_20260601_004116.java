// Last updated: 6/1/2026, 12:41:16 AM
1import java.util.Arrays;
2class Solution {
3    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
4        Arrays.sort(asteroids);
5        long currMass = mass; 
6        for (int asteroid : asteroids) {
7            if (currMass < asteroid) {
8                return false;
9            }
10            currMass += asteroid;
11        }
12        return true;
13    }
14}