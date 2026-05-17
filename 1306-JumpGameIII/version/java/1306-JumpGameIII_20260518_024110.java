// Last updated: 5/18/2026, 2:41:10 AM
1class Solution {
2    public boolean canReach(int[] arr, int start) {
3        boolean[] visited = new boolean[arr.length];
4        
5        return dfs(arr, start, visited);
6    }
7    private boolean dfs(int[] arr, int index, boolean[] visited) {
8        if (index < 0 || index >= arr.length || visited[index]) {
9            return false;
10        }
11        if (arr[index] == 0) {
12            return true;
13        }
14        visited[index] = true;
15        return dfs(arr, index + arr[index], visited) ||
16               dfs(arr, index - arr[index], visited);
17    }
18}