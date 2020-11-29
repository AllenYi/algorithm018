package com.arithmeticHomeWorkSix;

import java.util.Arrays;

public class six_two {

    public  int uniquePaths(int m,int n){
//        int[][] dp = new int[m][n];//首先用数组来保存每一步的值
//        //最左边和最右边的格子数值都是为1所以这里先都赋值
//        for(int i=0;i<m;i++)dp[i][0] =1;
//        for(int j=0;j<n;j++)dp[0][j] = 1;
//        for (int i = 1;i<m;i++){
//            for (int j=1;j<n;j++){
//                dp[i][j] = dp[i-1][j]+dp[i][j-1]; //套入公式计算,当前点的值等于右边和下边值的和
//            }
//        }
//        return dp[m-1][n-1];
        //简化版 我们只需要一个一维数组，然后每次累加一行累自底向上
        int[] cur = new int[n];
        Arrays.fill(cur,1); //填充数组
        //循环遍历累加
        for (int i=1;i<m;i++){
            for (int j =1;j<n;j++){
                cur[j]+=cur[j-1];
            }
        }
        return cur[n-1];

    }

}
