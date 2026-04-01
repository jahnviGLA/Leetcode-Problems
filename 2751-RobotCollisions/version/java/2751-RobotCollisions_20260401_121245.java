// Last updated: 4/1/2026, 12:12:45 PM
1import java.util.*;
2
3class Solution {
4    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
5        int n = positions.length;
6        int[][] robots = new int[n][4];
7        for (int i = 0; i < n; i++) {
8            robots[i][0] = positions[i];
9            robots[i][1] = healths[i];
10            robots[i][2] = directions.charAt(i); 
11            robots[i][3] = i; 
12        }
13        Arrays.sort(robots, (a, b) -> a[0] - b[0]);
14        Stack<Integer> stack = new Stack<>();
15        for (int i = 0; i < n; i++) {
16            if (robots[i][2] == 'R') {
17                stack.push(i);
18            } else {
19                while (!stack.isEmpty() && robots[i][1] > 0) {
20                    int j = stack.peek();
21                    if (robots[j][1] < robots[i][1]) {
22                        stack.pop();
23                        robots[i][1]--;
24                        robots[j][1] = 0;
25                    } else if (robots[j][1] > robots[i][1]) {
26                        robots[j][1]--;
27                        robots[i][1] = 0;
28                        break;
29                    } else {
30                        robots[j][1] = 0;
31                        robots[i][1] = 0;
32                        stack.pop();
33                        break;
34                    }
35                }
36            }
37        }
38        int[] result = new int[n];
39        Arrays.fill(result, -1);
40        for (int i = 0; i < n; i++) {
41            if (robots[i][1] > 0) {
42                result[robots[i][3]] = robots[i][1];
43            }
44        }
45        List<Integer> ans = new ArrayList<>();
46        for (int x : result) {
47            if (x != -1) ans.add(x);
48        }
49        return ans;
50    }
51}