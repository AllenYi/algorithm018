package com.arithmeticHomeWorkThree;

//剑指 Offer 06. 从尾到头打印链表
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//示例 1：
//输入：head = [1,3,2]
//输出：[2,3,1]

import java.util.ArrayList;
import java.util.List;

public class zero_six {
    public int[] reversePrint(ListNode head) {
        List<Integer> list =  new ArrayList<>();
        inorn(head,list);
        int[] res = new int[list.size()];
        for (int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public void inorn(ListNode node,List<Integer> res){
        if (node==null) return ;
        inorn(node.next,res);
        res.add(node.val);
    }

      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


}
