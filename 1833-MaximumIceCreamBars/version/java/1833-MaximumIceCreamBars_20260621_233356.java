// Last updated: 6/21/2026, 11:33:56 PM
1class Solution {
2    public int maxIceCream(int[] costs, int coins) {
3        int maxCost = 0;
4        for (int cost : costs) {
5            maxCost = Math.max(maxCost, cost);
6        }
7        int[] freq = new int[maxCost + 1];
8        for (int cost : costs) {
9            freq[cost]++;
10        }
11        int iceCreams = 0;
12        for (int price = 1; price <= maxCost; price++) {
13            while (freq[price] > 0 && coins >= price) {
14                coins -= price;
15                iceCreams++;
16                freq[price]--;
17            }
18            if (coins == 0) {
19                break;
20            }
21        }
22        return iceCreams;
23    }
24}