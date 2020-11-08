package com.arithmeticHomeWorkThree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class one_five {
    //15. 三数之和  给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三组
// 注意：答案中不可以包含重复的三元组。
// 示例：
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
// 满足要求的三元组集合为：
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
    public List<List<Integer>> threeSum(int[] nums) {// 总时间复杂度：O(n^2)

        List<List<Integer>> ans = new ArrayList<>();
        if (null==nums || nums.length<=2) return ans; //判断数组是否符合
        Arrays.sort(nums);//从小到大排序 O(nlogn)时间复杂度

        for (int i=0;i<nums.length -2;i++){
            if (nums[i]>0)break;//当第一个数都大于0，那么此数组不成立
            if (i>0&&nums[i] ==nums[i-1]) continue;//去掉重复值 两个相同的元素
            int target= -nums[i];
            int left =i+1,right = nums.length-1;//双指针头尾向中间靠拢
            while(left<right){ //判断不会交集
                if (nums[left] +nums[right]== target){//当相加等于0条件成立
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));//添加到结果集
                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++;right--; //首先无论如何都要先进行加减操作因为上面已经是成立了一个条件进入的
                    while (left<right && nums[left]==nums[left -1]) left++;
                    while(left<right && nums[right] ==nums[right+1]) right--;
                } else if (nums[left]+nums[right]<target){//相加小于目标值则左指针往前移动 +
                    left++;
                } else if (nums[left] + nums[right]>target) {//相加大于目标值则右指针往后移动 -
                    right--;
                }

            }

        }
        return ans;


    }
}
