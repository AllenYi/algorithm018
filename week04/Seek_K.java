package com.arithmeticHomeWorkFour;
//面试题 17.09. 第 k 个数有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。
// 例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
//示例 1:
//输入: k = 5
//输出: 9

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Seek_K {
    public int getKthMagicNumber(int k) {
//       //1.动态规划，小根堆
//       int p3=0,p5=0,p7=0;//定义三个指针p3,p5,p7
//       int[] dp= new int[k];
//       dp[0]=1;//初始化所有指针都指向第一个丑数，即1
//       for(int i=1;i<k;i++){
// //从dp[p3]*3,dp[p5]*5,dp[p7]*7选取最小的一个数字，作为新的丑数。
// //这边新的丑数就是3*dp[p3]=3*1=3，然后p3++此时p5和p7指向第1个丑数，p3指向第2个丑数。然后重复上一步
//           dp[i]=Math.min(dp[p3]*3,Math.min(dp[p5]*5,dp[p7]*7));
// //这里基于的一个事实是，丑数数列是递增的，当p5指针在当前位置时，后面的数乘以5必然比前面的数乘以5大，所以下一个丑数必然是先考虑前面的数乘以5。p3,p7同理，所以才可以使用指针
//           if(dp[i]==dp[p3]*3) p3++;
//           if(dp[i]==dp[p5]*5) p5++;
//           if(dp[i]==dp[p7]*7) p7++;
//       }
//       return dp[k-1];

        //2.使用堆方法用 HashSet 保存k个位数值
// 循环获取 HashSet 中的第k位
// 循环中获取最小位元素，如果该数不在HashSet中 写入
// 返回HashSet中第k个位数值
        // 最小堆处理写入数值  Integer不够 要用Long类型
        Queue<Long> PriorityQueue = new PriorityQueue<>();
        // HashSet 保存k个位数值
        Set<Long> list= new HashSet<>();
        PriorityQueue.add(1L);
        while(true){
            //得到优先队列的队首元素并且删除
            Long val = PriorityQueue.poll();
            //判断val元素是否已经存在HsahSet中如果不存在则插入
            if(!list.contains(val)){
                list.add(val);
                //通过优先队列，每次取出最小的一个，然后乘以3，5，7得到的值放入队列中
                PriorityQueue.add(val*3);
                PriorityQueue.add(val*5);
                PriorityQueue.add(val*7);
            }
            if(list.size()==k){
                return val.intValue();
            }
        }

    }
}
