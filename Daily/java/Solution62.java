/**
 * 62.路径的条数
 * DP动态规划
 * @author xuhao
 * @date Created at 2022/7/8 15:09
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        arr[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    // 状态转移方程
                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
                } else if (i > 0) {
                    // 这里是j=0的情况，也就是最左面的行
                    arr[i][j] = arr[i-1][j];
                } else if (j > 0) {
                    // 这里是i=0的情况，也就是最上面的行
                    arr[i][j] = arr[i][j-1];
                }
            }
        }
        return arr[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution62 solution62 = new Solution62();
        int num = solution62.uniquePaths(9, 9);
    }
}
