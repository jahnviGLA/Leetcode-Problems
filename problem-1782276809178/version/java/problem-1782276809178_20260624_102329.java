// Last updated: 6/24/2026, 10:23:29 AM
1class Solution {
2    public int diagonalSum(int[][] mat) {
3        int sum=0, j=mat.length-1;
4        for(int i=0;i<mat.length;i++){
5            sum+= mat[i][i];
6            sum+=mat[i][j];
7            j--;
8        }
9        if(mat.length%2==0){
10            return sum;
11        }
12        else{
13            return sum- mat[mat.length/2][mat.length/2];
14        }
15    }
16}