package com.arithmeticHomeWorkFour;
//33. 搜索旋转排序数组
//给你一个升序排列的整数数组 nums ，和一个整数 target 。
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
//请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//示例 1：
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
//示例 2：
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1
//示例 3：
//输入：nums = [1], target = 0
//输出：-1
public class three_three {
    public int search(int[] nums, int target) {
        //暴力求解，时间复杂度为O(n)
//        int len = nums.length;
//        for (int i = 0; i < len; i++) {
//            if (nums[i] == target) {
//                return i;
//            }
//        }
//        return -1;


        //二分法 ：中间元素把待搜索区间分成了两部分，两部分具有的性质是至少有一部分是有序的。
    int len = nums.length;
    if (len==0)return -1;
    int left=0;//左边界
    int  right = len-1;//右边界'
    while (left<right){//终结条件
        int mid= left +(right - left +1)/2;//得到从左开始的中间数必须在括号里面+1
        if (nums[mid]<nums[right]){//判断翻转的点在左还是右,条件成立则target在mid和right之间
            if (nums[mid]<=target && target<=nums[right]){
                //则下一轮的搜索区间在num[mid] 和 num[right] 之间
                left=mid; //则把mid变为新的left
            }else {
                right = mid-1;//否则就是mid-1变为新的right
            }
        }else {//这里则target在left和mid之间
            if (nums[left]<=target && target<=nums[mid-1]){//// 下一轮搜索区间是 [left, mid - 1]
                right = mid-1;
            }else {
                left =mid;
            }
        }
    }
    //如果区域间不存在target目标函数
    if (nums[left]==target){
        return left;
    }
  return  -1;















    }
}
