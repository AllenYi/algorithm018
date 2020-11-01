package com.arithmeticHomeWork;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Three_hundred_and_fifty {
    //350. 两个数组的交集 II
    //给定两个数组，编写一个函数来计算它们的交集。
    //结题思路 使用hashMap 哈希表
//方法一：哈希表
//由于同一个数字在两个数组中都可能出现多次，因此需要用哈希表存储每个数字出现的次数。对于一个数字，其在交集中出现的次数等于该数字在两个数组中出现次数的最小值。
//
//首先遍历第一个数组，并在哈希表中记录第一个数组中的每个数字以及对应出现的次数，然后遍历第二个数组，对于第二个数组中的每个数字，如果在哈希表中存在这个数字，则将该数字添加到答案，并减少哈希表中该数字出现的次数。
//
//为了降低空间复杂度，首先遍历较短的数组并在哈希表中记录每个数字以及对应出现的次数，然后遍历较长的数组得到交集。

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length>nums2.length){intersect(nums2,nums1);}//取出长度比较小的数组来进行Hash 赋值
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1 ){
            int count = map.getOrDefault(num,0)+1;
            map.put(num,count); //push进Hash表 num作为key值不变，count
        }
        int[] intersection = new int[nums1.length];
        int index=0;
        for (int num : nums2){
            int count = map.getOrDefault(num,0);//如果num在nums1里面也存在 得到num在nums1里面出现了多少次
            if (count>0){//如果大于0次
                intersection[index++]=num;//则num属于交集 放到新建的交集数组里面
                count--; //记得次数要减一
            }else {
                map.remove(num);//删除不存在的交集
            }
        }
       return Arrays.copyOfRange(intersection,0,index);// Arrays.copyOfRange 相当于clone 只不过是把 intersection 长度为0到index的这一段复制
    }


}
