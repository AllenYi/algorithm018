package com.arithmeticHomeWork;

import java.util.Deque;
import java.util.LinkedList;

public class Fifty_Nine {
   //59. 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
   // 双向队列大家都知道，既能在头部进行插入、删除操作，也能在尾部进行插入删除操作，而所谓的单调，
    // 就是我们人为规定从队列的头部到尾部，所存储的元素是依次递减（或依次递增）的。这里考察的就是单向的双端队列就是说，
    // 我们维护一个单调的双向队列，窗口在每次滑动的时候，我就从队列头部取当前窗口中的最大值，每次窗口新进来一个元素的时候，
    // 我就将它与队列中的元素进行大小比较：
    //
    //如果刚刚进来的元素比队列的尾部元素大，那么先将队列尾部的元素弹出，然后把刚刚进来的元素添到队列的尾部；
    //如果刚刚进来的元素比队列的尾部元素小，那么把刚刚进来的元素直接添到队列的尾部即可。



    public int[] maxSlidingWindow(int[] nums, int k) {
        if (0==nums.length || 0==k)return new  int[0];
        int[] res = new int[nums.length-k+1]; //首先new 一个新的数组来作为返回值 初始化长度
        Deque<Integer> deque = new LinkedList<>();
         for (int j=0,i=1-k;j<nums.length;j++,i++){//循环遍历整个数组
             if (i>0 && deque.peekFirst() == nums[i-1]){//当i>0可以形成窗口之后 队首元素deque[0] = 被删除元素numss[i-1]
                 deque.removeFirst();//删除deque中对应的nums[i-1] 队首元素出队
             }
             while(!deque.isEmpty() && deque.peekLast()<nums[j]){//当队列中的最后一个值小于nums[j]的时候我们要删掉保持deque的递减
                 deque.removeLast();
             }
             deque.addLast(nums[j]);//先将nums数组内所有的值都存放到双端队列中 而且是队列往后添加
             if (i>=0){//这时候已经形成窗口
                 res[i] = deque.peekFirst();//保存窗口最大值
             }
         }


        return  res;
    }

}
