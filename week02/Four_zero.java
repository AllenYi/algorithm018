package com.arithmeticHomeWork;
// 40. 最小的k个数  输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Four_zero {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public  int[] getLeastNumbers(int[] arr, int k){
        //1.直接循环遍历
//        int[] sum = new int [k];
//        Arrays.sort(arr);//sort从小打大排序
//        for (int i=0;i<k;i++){
//            sum[i]=arr[i];
//        }
//        return sum;

        //2.堆的方法
        //先定义一个优先队列
        PriorityQueue<Integer> heap = new PriorityQueue<>();
       for (int i=0;i<arr.length;i++){
           heap.add(arr[i]); //把arr放入heap
       }
       int[] ans =  new int[k];
       for (int i = 0 ;i<k;i++){
           ans[i] = heap.poll(); //然后依次poll()方法每次取出heap最小值并且删除
       }
        return ans;


        }

}
