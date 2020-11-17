package com.arithmeticHomeWorkFour;

import java.util.Arrays;

//153. 寻找旋转排序数组中的最小值
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
//请找出其中最小的元素。
//示例 1：
//输入：nums = [3,4,5,1,2]
//输出：1
//示例 2：
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
//示例 3：
//输入：nums = [1]
//输出：1
public class one_five_three {
    public int findMin(int[] nums) {
        //直接调用API
//        Arrays.sort(nums);
//        return nums[0];
    //2采用二分法找到 官方
//    int len = nums.length;
//    if (len==1){//特殊条件
//        return nums[0];
//    }
//    int left=0,right=len-1;
//    if (nums[right]>nums[left]){
//        return  nums[0];
//    }
//    while (left<=right){
//        int  mid=left+(right-left)/2;//中间点 二分
//        if (nums[mid]>nums[mid+1]){
//            return nums[mid+1];//刚好找到
//        }
//        if (nums[mid]>nums[0]){
//            left =mid+1;//往右偏移
//        }else {
//            right= mid-1;//往左偏移
//        }
//    }
//    return -1;
   //自己写的，做了33题搜索旋转排序数组之后这一题就基本套公式解决了
        //2采用二分法找到
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2; //得到中间点
            if (nums[mid] > nums[right]) {   //当中间点大于最右边的值则target值在中间点和最右边之间
                left = mid + 1;//则最左边届变成了中间点 记得+1
            } else {
                right = mid; //否则中间点就当做下一次的右边界
            }
        }
        return nums[left];


    }
}
