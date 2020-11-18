import java.io.*; 
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] results = new int[m+1][n+1];
        return calucateUniquePaths(m, n, 1, 1, results);
    }
    
    public int calucateUniquePaths(int m, int n, int r, int c, int[][] result){
        if(r > m || c > n) {
            return 0;
        }
        if(r == m && c == n){
            return 1;
        }
        if(result[r][c] != 0){
            return result[r][c];
        }
        int up1 = calucateUniquePaths(m, n, r+1, c, result);
        int up2 = calucateUniquePaths(m, n, r, c+1, result);
        result[r][c] = up1 + up2;
        return up1 + up2; 
    }
}