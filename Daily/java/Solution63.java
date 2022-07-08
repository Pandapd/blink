/**
 * 63.带障碍物的不同路径
 * DP动态规划
 *
 * 没什么不同，只是在又路障的位置，到达该坐标的路径条数为0
 * @author xuhao
 * @date Created at 2022/7/8 15:28
 */
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];

        f[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果该位置没有路障则计算，否则路径条数就是0
                if (obstacleGrid[i][j] != 1) {
                    if (i > 0 && j > 0) {
                        // 状态转移方程
                        f[i][j] = f[i-1][j] + f[i][j-1];
                    } else if (i > 0) {
                        // 这里是j=0的情况，也就是最左面的行
                        f[i][j] = f[i-1][j];
                    } else if (j > 0) {
                        // 这里是i=0的情况，也就是最上面的行
                        f[i][j] = f[i][j-1];
                    }
                }
                // else {直接继续循环}
            }
        }
        return f[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution63 solution63 = new Solution63();
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        solution63.uniquePathsWithObstacles(grid);
    }
}
