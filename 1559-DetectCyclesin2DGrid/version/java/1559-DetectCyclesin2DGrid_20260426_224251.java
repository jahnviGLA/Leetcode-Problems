// Last updated: 4/26/2026, 10:42:51 PM
1class Solution {
2    int rows, cols;
3    boolean[][] visited;
4    public boolean containsCycle(char[][] grid) {
5        rows = grid.length;
6        cols = grid[0].length;
7        visited = new boolean[rows][cols];
8        for(int i=0;i<rows;i++){
9            for(int j=0;j<cols;j++){
10                if(!visited[i][j]){
11                    if(dfs(grid,i,j,-1,-1,grid[i][j])){
12                        return true;
13                    }
14                }
15
16            }
17        }
18        return false;
19    }
20    private boolean dfs(char[][] grid,
21                        int r,
22                        int c,
23                        int parentR,
24                        int parentC,
25                        char ch){
26        visited[r][c]=true;
27        int[][] dir = {
28            {1,0},
29            {-1,0},
30            {0,1},
31            {0,-1}
32        };
33        for(int[] d : dir){
34            int nr = r + d[0];
35            int nc = c + d[1];
36            if(nr<0 || nc<0 || nr>=rows || nc>=cols)
37                continue;
38            if(grid[nr][nc] != ch)
39                continue;
40            if(nr==parentR && nc==parentC)
41                continue;
42            if(visited[nr][nc])
43                return true;
44            if(dfs(grid,nr,nc,r,c,ch))
45                return true;
46        }
47        return false;
48    }
49}