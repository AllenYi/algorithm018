package com.arithmeticHomeWork;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

//347. 前 K 个高频元素你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
//你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
//题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
//你可以按任意顺序返回答案。
//示例 1:
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//示例 2:
//输入: nums = [1], k = 1
//输出: [1]
public class three_four_seven {
//最简单粗暴的思路就是 使用排序算法对元素按照频率由高到低进行排序，然后再取前 k个元素。
//可以发现，使用常规的诸如 冒泡、选择、甚至快速排序都是不满足题目要求，它们的时间复杂度都是大于或者等于 O(n log⁡n)O(nlog⁡n)，而题目要求算法的时间复杂度必须优于 O(n log n)O(nlogn)。
//
//复杂度分析
//时间复杂度：O(nlogn)O(nlogn)，nn 表示数组长度。首先，遍历一遍数组统计元素的频率，这一系列操作的时间复杂度是 O(n)O(n)；接着，排序算法时间复杂度为 O(nlogn)O(nlogn)；因此整体时间复杂度为 O(nlogn)O(nlogn)。
//空间复杂度：O(n)O(n)，最极端的情况下（每个元素都不同），用于存储元素及其频率的 Map 需要存储 nn 个键值对。

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) { //当这个nums中有元素出现两次则map中同key的value+1
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 遍历map，优先队列来用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            if (pq.size() < k) { //队列中的总数少于K则添加到pd队列
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) { //每次都将新的元素与堆顶元素（堆中频率最小的元素）进行比较，判断如果map.get(key)新的元素出现的评率比堆pd顶端的元素大
                pq.remove();//弹出队列pd顶端的元素
                pq.add(key);//新的元素添加至pd队列
            }
        }
        // 取出最小堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());// 添加至res,添加完了的删除pd中的元素直至pd为空
        }
        return res;
    }


}
