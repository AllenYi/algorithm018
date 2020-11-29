package com.arithmeticHomeWorkSix;

import java.util.List;

public class one_two_zero {
//    相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

//    例如，给定三角形：
//
//
//            [2],
//            [3,4],
//            [6,5,7],
//            [4,1,8,3]
//            ]
//    自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

    public int minimumToal(List<List<Integer>> triangle){
        int row =  triangle.size();//获取整个长度
        int[]minlen = new int[row+1];
        //DP自底向上遍历 level 代表层
        for (int level = row-1;level>=0;level--){
            for (int i =0;i<=level;i++){ //i 每一层的个数 //第i行有i+1个数字
                //Math.min(minlen[i],minlen[i+1]) 判断下面相邻两个数比较小的，triangle.get(level).get(i)本身的值
                minlen[i] = Math.min(minlen[i],minlen[i+1])+triangle.get(level).get(i);
            }
        }
        return minlen[0];



    }
}
