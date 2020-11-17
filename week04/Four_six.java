package com.arithmeticHomeWorkFour;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//46. 全排列
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//        示例:
//        输入: [1,2,3]
//        输出:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]
public class Four_six {

    public List<List<Integer>> permute(int[] nums) {
       int len =  nums.length;//得到数组的长度
        List<List<Integer>> res = new ArrayList<>();//动态列表来存放最终的结果
        if (len==0)return res;
        Deque<Integer> path = new ArrayDeque<>();//栈来保存作为path 已经选择了哪些数
        //递归到第几层depth
        boolean[]  used = new boolean[len];//boolean数组来进行当前考虑的数字是否被选择初始化都为false(已空间换时间)
        ////这里刚开始所以第一层depth为0
        dfs(nums,len,0,path,used,res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
      if (depth==len){//当前递归的层数等于数组的长度,所有的数都考虑完了则得到一个排列
          //将path添加到res中 全局仅此一份，添加只是添加引用为了避免path会返回到根节点为空所以用new来操作，
          // 这样在结果集才不会出现很多重复的空列表
          res.add(new ArrayList<>(path));
          return;
      }
      for (int i=0;i<len;i++){
          if (used[i]){//当这个数已经被使用过了则跳过
              continue;
          }
          path.addLast(nums[i]); //没有使用过就把它放到栈里面去
          used[i]=true;//修改boolean树值为true
          //然后继续递归 ,其余的数都不用变，只需要将depth层数加一
          dfs(nums,len,depth+1,path,used,res);
          //在递归完成之后需要回到上一层，这时候之前做的操作我们都需要相应逆操作
          path.removeLast();
          used[i]=false;
      }

    }


}
