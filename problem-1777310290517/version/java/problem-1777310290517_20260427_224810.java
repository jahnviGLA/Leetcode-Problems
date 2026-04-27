// Last updated: 4/27/2026, 10:48:10 PM
1class Solution {
2    int[][] dirs = {
3        {0,-1}, {0,1}, {-1,0}, {1,0}
4    };
5    int[][][] paths = {
6        {}, 
7        {{0,-1},{0,1}},      
8        {{-1,0},{1,0}},      
9        {{0,-1},{1,0}},      
10        {{0,1},{1,0}},     
11        {{0,-1},{-1,0}},    
12        {{0,1},{-1,0}}       
13    };
14    public boolean hasValidPath(int[][] grid) {
15        int m = grid.length;
16        int n = grid[0].length;
17        boolean[][] visited = new boolean[m][n];
18        return dfs(0,0,grid,visited);
19    }
20    private boolean dfs(int i, int j, int[][] grid, boolean[][] visited){
21        int m = grid.length;
22        int n = grid[0].length;
23        if(i==m-1 && j==n-1)
24            return true;
25        visited[i][j] = true;
26        for(int[] d : paths[grid[i][j]]){
27            int ni = i + d[0];
28            int nj = j + d[1];
29            if(ni<0 || nj<0 || ni>=m || nj>=n || visited[ni][nj])
30                continue;
31            if(isConnectedBack(ni,nj,-d[0],-d[1],grid)){
32                if(dfs(ni,nj,grid,visited))
33                    return true;
34            }
35        }
36        return false;
37    }
38    private boolean isConnectedBack(int i,int j,int x,int y,int[][] grid){
39        for(int[] d : paths[grid[i][j]]){
40            if(d[0]==x && d[1]==y)
41                return true;
42        }
43        return false;
44    }
45}