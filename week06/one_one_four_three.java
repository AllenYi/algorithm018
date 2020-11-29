package com.arithmeticHomeWorkSix;

public class one_one_four_three {
    public int longestCommonSubsequence(String text1,String text2){
        int m = text1.length();
        int n= text2.length();
        int[][]dp = new int[m+1][n+1]; //初始化二维数组
        for (int i=1;i<m+1;i++){ //循环遍历
            for (int j=1;j<n+1;j++){
                if (text1.charAt(i-1)==text2.charAt(j-1)){//当最后一个字符相同
                    dp[i][j]= dp[i-1][j-1]+1; //值就是除去最后一个字符的长度 加 1
                }else {
                    //否则就是两者长度相比较的最大值
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
