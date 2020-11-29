package com.arithmeticHomeWorkSix;
//221. 最大正方形
//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
////示例：输入：
//matrix = [["1","0","1","0","0"],
//          ["1","0","1","1","1"],
//          ["1","1","1","1","1"],
//          ["1","0","0","1","0"]]
//输出：4
public class two_two_one {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if(n == 0) return 0;
        int m = matrix[0].length;
        if(m == 0) return 0;
        int[][] dp = new int[n][m];
        int result = 0; //正方形的最大边长
        //初始化base case
        for(int i = 0 ;i<n;i++) {//遍历行找到一行中最大的值
            dp[i][0] = matrix[i][0] - '0';
            result = Math.max(dp[i][0],result);
        }
        for(int i = 0 ;i<m;i++){//遍历列找到一列中最大的值
            dp[0][i] = matrix[0][i] - '0';
            result = Math.max(dp[0][i],result);
        }
        for(int i = 1; i<n; i++){
            for(int j = 1; j<m; j++){
                //计算dp[i][j];
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]) + 1;
                    result = Math.max(dp[i][j],result);
                }
            }
        }
        return result*result;

    }

}
